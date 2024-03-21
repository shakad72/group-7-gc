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


/**
 * Class that displays menus to the user starting with the menu defined in xml_config/index.xml
 */
public class MenuHandler {


    // Variable that will hold the menu title
    private final String menuTitle;
    // Variable that will hold the menu prompt
    private final String menuPrompt;
    // Variable that will contain the list of menu items and their respective actions (display report, display another menu, exit etc.)
    private final ArrayList<MenuItem> menuItems = new ArrayList<>();
    // Message that will be displayed to the user if an invalid menu selection is made
    private static final String invalidSelectionMessage = "You did not choose a valid selection. Please try again...";


    /**
     * Class constructor.
     *
     * @param fileName Name of file containing XML menu definitions
     */
    public MenuHandler(String fileName) throws IOException {
        // Parse XML file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            // Declare an document builder object
            builder = factory.newDocumentBuilder();
            // Parse the XML file
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
            // Throw a RunTime exception to the calling method
            throw new RuntimeException(e);
        } catch (IOException e) {
            // Throw the IOException to the calling method
            throw new IOException(e);
        }
        // Display menu to the user
        displayMenu();
    }


    /**
     * Method that will render the menu to the user based on what was loaded by the class constructor.
     */
    private void displayMenu() {
        // Variable that will signal the user's intention to navigate to the previous menu
        boolean previousMenuSignal = false;
        // Repeat until the signal to navigate to the previous menu is given
        do {
            // Variable that will be set to true if a valid manu selection is made
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
            // If there is something in the scanner then clear it
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


    /**
     * Method that is called when the user selects a menu item that exits the application.
     */
    private void handleExit(){
        // Disconnect from DB and exit
        App.disconnect();
        System.out.println("Bye!");
        System.exit(0);
    }


    /**
     * Method that is called when the user selects a menu item for a report.
     *
     * @param item Reference to the menuItem for the report chosen by the user
     */
    private void handleReport(MenuItem item){
        // Attempt to display the report by instantiating a new ReportHandler object
        try {
            new ReportHandler(item, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Method that is called when the user selects a menu item for a sub-menu.
     *
     * @param item Reference to the menuItem for the menu chosen by the user
     */
    private void handleMenu(MenuItem item){
        try {
            // Get URL for the index.xml file in the resources directory
            URL indexUrl = App.class.getClassLoader().getResource("xml_config/"+item.getFile());
            if(indexUrl==null){
                // Display error message and exit if the file referenced in the MenuItem variable was not found
                System.out.println("Error: " + item.getFile() + " file was not found in the resources/xml_config directory");
                System.exit(-1);
            }else{
                // Display menu if the file referenced in the MenuItem variable was found
                new MenuHandler(indexUrl.toString());
            }
        } catch (IOException e) {
            // Display error message
            System.out.println("Error: IOException encountered while processing "+item.getFile()+" file");
        }
    }
}