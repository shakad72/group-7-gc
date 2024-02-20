package com.napier.sem;

import java.sql.*;

public class App
{

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;
    /**
     * Variables used to establish a connection to MySQL database.
     */
    private static final String DB_HOST = "localhost";
    private static final int DB_PORT = 3306;
    private static final String DB_LOGIN = "root";
    private static final String DB_PASSWORD = "group-7-gc";
    private static final int DB_CONNECTION_ATTEMPTS = 10;


    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Disconnect from database
        a.disconnect();
    }


    /**
     * Connect to the MySQL database.
     */
    public void connect()
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
            System.out.printf("Connecting to database (attempt %d of %d)...\r\n", i+1, DB_CONNECTION_ATTEMPTS);
            try
            {
                // Connect to database
                con = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/world?useSSL=false&allowPublicKeyRetrieval=true",DB_HOST,DB_PORT), DB_LOGIN, DB_PASSWORD);
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException e)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(e.getMessage());
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
    public void disconnect()
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