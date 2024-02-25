package com.napier.sem;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuHandler {

    private final String menuTitle;
    private final String menuPrompt;
    private final ArrayList<MenuItem> menuItems = new ArrayList<>();
    private static final String invalidSelectionMessage = "You did not choose a valid selection. Please try again...";

    /**
     * @param fileName Name of file containing XML menu definitions
     */
    public MenuHandler(String fileName) throws IOException {
        // Read XML file containing menu definitions
//        try {
//            String xml = Files.readString(Paths.get(fileName));
//        } catch (IOException e) {
//            throw new IOException(e);
//        }
        // Parse XML file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fileName);
            // Retrieve menu title
            NodeList menuNodes = doc.getElementsByTagName("menu");
            this.menuTitle = menuNodes.item(0).getAttributes().getNamedItem("title").getNodeValue();
            // Retrieve menu prompt
            this.menuPrompt = menuNodes.item(0).getAttributes().getNamedItem("prompt").getNodeValue();
            // Retrieve menu items
            NodeList menuItemNodes = doc.getElementsByTagName("menuItem");
            for (int i = 0; i < menuItemNodes.getLength(); i++) {
                // Retrieve message (content between menuItem elements
                String message = menuItemNodes.item(i).getTextContent();
                NamedNodeMap nodeMap = menuItemNodes.item(i).getAttributes();
                // Retrieve ID attribute
                String id = nodeMap.getNamedItem("id").getNodeValue();
                // Retrieve action attribute
                String action = nodeMap.getNamedItem("action").getNodeValue();
                // Retrieve optional file attribute
                String file = null;
                if (nodeMap.getNamedItem("file") != null) {
                    file = nodeMap.getNamedItem("file").getNodeValue();
                }
                // Add menuItem object to menuItems ArrayList
                this.menuItems.add(new MenuItem(id, action, file, message));
            }
        } catch (ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new IOException(e);
        }
        // Display menu
        displayMenu();
    }

    private void displayMenu() {
        boolean previousMenuSignal = false;
        do {
            boolean validSelection = false;
            // Display menu title
            System.out.println(this.menuTitle);
            // Display menu items
            for (MenuItem i : menuItems) {
                System.out.printf("%s - %s%n", i.getId(), i.getMessage());
            }
            // Display prompt
            System.out.printf("%s: ", this.menuPrompt);
            // Read menu selection
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            // Is selection valid?
            for (MenuItem i : menuItems) {
                // Is the selection for this menu item?
                if(input.equalsIgnoreCase(i.getId())) {
                    // Yes. Menu selection found
                    validSelection = true;
                    // Exit application if EXIT action was selected
                    switch(i.getAction().toUpperCase()){
                        case "MENU":
                            // Jump to another menu
                            handleMenu(i);
                            break;
                        case "REPORT":
                            // Execute a report
                            handleReport(i);
                            break;
                        case "PREVIOUS":
                            // Set signal that indicates we want to exit this menu
                            previousMenuSignal=true;
                            break;
                        case "EXIT":
                            // Exit application
                            handleExit();
                            break;
                    }
                }
            }
            // Display message if value selection is false
            if(!validSelection){
                System.out.println(MenuHandler.invalidSelectionMessage);
            }
        } while (!previousMenuSignal);
    }

    private void handleExit(){
        // Disconnect from DB and exit
        App.disconnect();
        System.out.println("Bye!");
        System.exit(0);
    }

    private void handleReport(MenuItem item){
        try {
            new ReportHandler(item);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void handleMenu(MenuItem item){
        try {
            // Get URL for the index.xml file in the resources directory
            URL indexUrl = App.class.getClassLoader().getResource("xml_config/"+item.getFile());
            if(indexUrl==null){
                System.out.println("Error: " + item.getFile() + " file was not found in the resources/xml_config directory");
                System.exit(1);
            }else{
                new MenuHandler(indexUrl.toString());
            }
        } catch (IOException e) {
            System.out.println("Error: IOException encountered while processing "+item.getFile()+" file");
        }
//        // Load a menu
//        try {
//            new MenuHandler(item.getFile());
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
