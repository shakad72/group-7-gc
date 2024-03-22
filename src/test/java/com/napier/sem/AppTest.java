package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @BeforeAll
    static void init()
    {
    }

    /**
     * Test application in non-interactive more where the XML report definition
     * file is specified as an argument.
     */
    @Test
    void NonInterfactiveTest()
    {
        // Specify report to execute (one that does not require interactive user input)
        String[] args = {"reports/report1.xml"};
        // Run the application with the args variable substituting for command line arguments
        App.main(args);
    }


}
