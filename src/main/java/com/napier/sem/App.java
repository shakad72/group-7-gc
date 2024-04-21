package com.napier.sem;

import java.io.IOException;
import java.net.URL;
import java.sql.*;


/**
 * Class containing the main static method.
 */
public class App
{
    // Static variable that will reference connection to database once established
    public static Connection con = null;

    // Host where world database is located
    private static final String DB_HOST = "localhost";  // Change to db when deploying using docker compose

    // Port to connect to MySQL database
    private static final int DB_PORT = 3306;

    // Login for MySQL database
    private static final String DB_LOGIN = "root";

    // Password for MySQL database
    private static final String DB_PASSWORD = "group-7-gc";

    // Number of times application will attempt to connect to MySQL (will wait 30 seconds between attempts)
    private static final int DB_CONNECTION_ATTEMPTS = 10;


    /**
     * Application execution starts here.
     * In interactive mode, no arguments should be provided when executing the application.
     * In non-interactive mode, the first argument should be the path of the XML report definition file.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args)
    {
        // Attempt to connect to the database
        App.connect();
        // Was connection successful?
        if (App.con != null) {
            // Connection was successfully established!. If an argument was supplied (args[1]) then execute the report
            if (args.length > 0) {
                // Enter non-interactive mode by executing the report in args[0]
                try {
                    new ReportHandler(args[0]);
                } catch (IOException e) {
                    System.out.println("Error: File not found at path " + args[0]);
                }
            } else {
                // Enter interactive mode by displaying top menu (defined in index.xml file)
                try {
                    // Get URL for the index.xml file in the resources directory
                    URL indexUrl = App.class.getClassLoader().getResource("xml_config/index.xml");
                    // Was there a problem?
                    if (indexUrl == null) {
                        // Display error message then exit
                        System.out.println("Error: index.xml file was not found in the resources/xml_config directory");
                        System.exit(-1);
                    } else {
                        // If there was no problem, then display the menu to the user
                        new MenuHandler(indexUrl.toString());
                    }
                } catch (IOException e) {
                    // Display IOException error message
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
     * Static method that attempts to connect to the MySQL database.
     */
    public static void connect()
    {
        // Attempt to load the MySQL JDBC driver
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            // Display error message and exit if unable to load the JDBC driver
            System.out.println("Error: Could not load SQL driver");
            System.exit(-1);
        }

        // Repeatedly attempt to connect to the MySQL database (wait 30 seconds between attempts)
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
            // Sleep for 30 seconds before trying again to connect
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                System.out.println("Error: Thread interrupted? Should not happen.");
            }
        }
    }


    /**
     * Static method that gracefully disconnects from the MySQL database.
     */
    public static void disconnect()
    {
        // Close MySQL connection if one was established
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error: Error encountered while closing connection to database");
            }
        }
    }
}