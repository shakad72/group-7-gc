package com.napier.sem;

import java.util.Scanner;


/**
 * Class that holds the parameters obtained via user input.
 */
public class ReportParameter {
    // Variable that will hold the name of the parameter requested
    private final String name;
    // Variable that will hold the prompt that should be displayed to the user when requesting the parameter
    private final String prompt;
    // Variable that will hold the parameter after it is obtained from the user
    private String value;


    /**
     * Class constructor.
     *
     * @param name Name of the parameter
     * @param prompt Prompt that should be displayed to the user when the parameter is requested
     */
    public ReportParameter(String name, String prompt){
        this.name = name;
        this.prompt = prompt;
    }


    /**
     * Method that will be called when requesting the parameter value from the user.
     */
    public void request(){
        // Display the prompt
        System.out.printf("%s: ", this.prompt);
        // Wait for the user to enter a value
        Scanner scanner = new Scanner(System.in);
        this.value = scanner.nextLine();
    }


    /**
     * Getter method for the name variable.
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Getter method for the value of the parameter.
     *
     * @return value
     */
    public String getValue() {
        return value;
    }
}