package com.napier.sem;

import org.junit.jupiter.api.*;

import java.io.IOException;

public class UnitTests {


    @BeforeAll
    static void init()
    {
        App.connect();
    }

    @AfterAll
    static void finalise(){
        App.disconnect();
    }

    @Test
    void testReportHandler() throws IOException {
        new ReportHandler("reports/report1.xml");
    }
}
