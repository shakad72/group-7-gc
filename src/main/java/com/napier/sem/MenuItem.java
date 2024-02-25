package com.napier.sem;

public class MenuItem {

    private final String id;
    private final String action;
    private final String file;
    private final String message;

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
