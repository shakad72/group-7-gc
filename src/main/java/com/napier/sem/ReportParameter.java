package com.napier.sem;

import java.util.Scanner;

public class ReportParameter {
    private final String name;
    private final String prompt;
    private String value;

    public ReportParameter(String name, String prompt){
        this.name = name;
        this.prompt = prompt;
    }

    /**
     * Set value by asking user for it
     */
    public void request(){
        System.out.printf("%s: ", this.prompt);
        Scanner scanner = new Scanner(System.in);
        this.value = scanner.nextLine();
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
