package com.napier.sem;

import java.io.IOException;
import java.net.URL;
import java.sql.*;

public class App
{

    /**
     * Connection to MySQL database.
     */
    public static Connection con = null;

    /**
     * Variables used to establish a connection to MySQL database.
     */
    private static final String DB_HOST = "db";  // Change to db when deploying using docker compose
    private static final int DB_PORT = 3306;
    private static final String DB_LOGIN = "root";
    private static final String DB_PASSWORD = "group-7-gc";
    private static final int DB_CONNECTION_ATTEMPTS = 10;

    /**
     * Application execution starts here.
     * @param args Command line arguments
     */
    public static void main(String[] args)
    {
        // Connect to database
        App.connect();
        // Was connection successful?
        if (App.con != null) {
            // Connection was successfully established!
            // If an argument was supplieg (args[1]) then execute the report else be interactive
            if (args.length > 0) {
                // Run report
                try {
                    new ReportHandler(args[0]);
                } catch (IOException e) {
                    System.out.println("Error: File not found at path " + args[1]);
                }
            } else {
                // Display top menu (defined in index.xml file)
                try {
                    // Get URL for the index.xml file in the resources directory
                    URL indexUrl = App.class.getClassLoader().getResource("xml_config/index.xml");
                    if (indexUrl == null) {
                        System.out.println("Error: index.xml file was not found in the resources/xml_config directory");
                        System.exit(1);
                    } else {
                        new MenuHandler(indexUrl.toString());
                    }
                } catch (IOException e) {
                    System.out.println("Error: IOException encountered while processing index.xml file");
                }
            }
            // Display message before ending application
            System.out.println("Bye!");
            // Disconnect from database
            App.disconnect();
        }
    }


    /**
     * Connect to the MySQL database.
     */
    public static void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        for (int i = 0; i < DB_CONNECTION_ATTEMPTS; ++i)
        {
            System.out.printf("Attempting to connect to database (attempt %d of %d)%n", i+1, DB_CONNECTION_ATTEMPTS);
            try
            {
                // Connect to database
                con = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/world?useSSL=false&allowPublicKeyRetrieval=true",DB_HOST,DB_PORT), DB_LOGIN, DB_PASSWORD);
                System.out.println("Successfully connected");
                System.out.println();
                break;
            }
            catch (SQLException e)
            {
                // Made less verbose by not displaying exception
            }
            // Wait a bit before trying again to connect
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }


    /**
     * Disconnect from the MySQL database.
     */
    public static void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

}