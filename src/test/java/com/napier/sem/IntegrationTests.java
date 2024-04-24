package com.napier.sem;

import org.junit.jupiter.api.Test;

public class IntegrationTests {

    @Test
    void completeNonInteractiveTest(){
        // Execute a report without prompting the user for input
        String[] args= {"-host","localhost","-port","3306","-reportDefinition","reports/report2.xml","-reportParameter","South America"};
        App.main(args);
    }
}