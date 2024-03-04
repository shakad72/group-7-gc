package com.napier.sem;


/**
 * Class that retains information retrieved from a "menuItem" element defined in a XML menu definition file eg. xml_config/index.xml
 */
public class MenuItem {

    // id attribute in menuItem element
    private final String id;
    // action attribute for menuItem element
    private final String action;
    // file attribute for menuItem element
    private final String file;
    // message attribute for menuItem element
    private final String message;


    /**
     * Class contructor that accepts all the attributes as parameters.
     *
     * @param id
     * @param action
     * @param file
     * @param message
     */
    public MenuItem(String id, String action, String file, String message){
        this.id = id;
        this.action = action;
        this.file = file;
        this.message = message;
    }


    /**
     * Get the ID for this menu item selection eg. E
     *
     * @return ID
     */
    public String getId() {
        return id;
    }


    /**
     * Get the action that should be performed when this menu item is selected
     *
     * @return MENU, REPORT, EXIT, or PREVIOUS
     */
    public String getAction() {
        return action;
    }


    /**
     * Get filename of the file containing XML menu definitions
     *
     * @return Filename
     */
    public String getFile() {
        return file;
    }


    /**
     * Get message that should be displayed for this menu item
     *
     * @return Menu item message
     */
    public String getMessage() {
        return message;
    }
}