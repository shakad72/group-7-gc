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
        String[] args= {"reports/report1.xml"};
        App.main(args);
    }
}
