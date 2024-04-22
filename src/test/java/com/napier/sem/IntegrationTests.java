package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class IntegrationTests {

    @BeforeAll
    static void init()
    {
    }

    @Test
    void connectTest(){
        App.connect();
        App.disconnect();
    }

    @Test
    void completeTest(){
        String[] args= {"-host","localhost","-port","3306","-reportDefinition","reports/report2.xml","-reportParameter","South America"};
        App.main(args);
    }
}
