package com.napier.sem;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * Class that will read an XML report definition file, ask for required input, execute the SQL query, then display results.
 * Will adjust the column widths to the widest value for each column (including the heading).
 */
public class ReportHandler {

    // Variable that will hold the title of the report
    private final String reportTitle;
    // Variable that will hold the SQL query
    private final String sql;
    // Variable that will hold the report parameters needed by the SQL query
    private final ArrayList<ReportParameter> reportParameters = new ArrayList<>();


    /**
     * Class constructor that will immediately display the report passed as an argument.
     *
     * @param file XML report desinition file eg. xml_config/country_reports/report_countryReport1.xml
     * @throws IOException
     */
    public ReportHandler(String file) throws IOException{
        // Create a MenuItem which references the XML report definition file and pass to another constructor
        this(new MenuItem(null,"report",file,null));
    }


    /**
     * Class constructor that will display the report pointed to by the passed MenuItem object.
     *
     * @param item reference to MenuItem object that has the path to the XML report definition file
     * @throws IOException
     */
    public ReportHandler(MenuItem item) throws IOException {
        // Instantiate a document builder factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        // Attempt to process the report
        try {
            builder = factory.newDocumentBuilder();
            // Get URL for the index.xml file in the resources directory
            URL fileUrl = App.class.getClassLoader().getResource("xml_config/" + item.getFile());
            if (fileUrl == null) {
                System.out.println("Error: " + item.getFile() + " file was not found in the resources/xml_config directory");
                System.exit(1);
            }
            // Parse XML document containing report definition
            Document doc = builder.parse(fileUrl.toString());
            // Retrieve menu title
            NodeList reportNodes = doc.getElementsByTagName("report");
            this.reportTitle = reportNodes.item(0).getAttributes().getNamedItem("title").getNodeValue();
            // Retrieve SQL query
            this.sql = doc.getElementsByTagName("sql").item(0).getTextContent();
            // Retrieve parameters
            NodeList parameterNodes = doc.getElementsByTagName("parameter");
            for (int i = 0; i < parameterNodes.getLength(); i++) {
                // Load parameters  (name, prompt, and type) into reportParameters array list
                NamedNodeMap nodeMap = parameterNodes.item(i).getAttributes();
                String name = nodeMap.getNamedItem("name").getNodeValue();
                String prompt = nodeMap.getNamedItem("prompt").getNodeValue();
                this.reportParameters.add(new ReportParameter(name, prompt));
            }
        } catch (ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new IOException(e);
        }
        // Ask user to input values for all parameters
        for (ReportParameter parameter : this.reportParameters) {
            parameter.request();
        }
        // Insert parameters into SQL query
        String sqlWithParameters = insertParameters();
        // Display menu
        displayReport(sqlWithParameters);
    }


    /**
     * Method that will execute SQL statement with parameters substituted and then display the formatted results.
     *
     * @param sqlWithParameters SQL statement
     */
    private void displayReport(String sqlWithParameters) {
        // Display report
        try {
            Statement stmt = App.con.createStatement();
            ResultSet results = stmt.executeQuery(sqlWithParameters);
            displaySQLResults(results);
        } catch (SQLException e) {
            // Display the SQL exception if one was encountered
            throw new RuntimeException(e);
        }
    }


    /**
     * Method that will display SQL results as a table.
     *
     * @param results ResultSet of executed SQL query
     */
    private void displaySQLResults(ResultSet results) throws SQLException {
        // Retrieve the number of columns in the table
        int columnCount = results.getMetaData().getColumnCount();
        // Declare array that will hold the width of each column
        int[] columnWidths = new int[columnCount];
        // Create an array list to store all values
        ArrayList<String[]> data = new ArrayList<>();
        // Retrieve the names of all columns
        String[] columnNames = new String[columnCount];
        for (int x = 0; x < results.getMetaData().getColumnCount(); x++) {
            columnNames[x] = results.getMetaData().getColumnLabel(x + 1);
            // Set initial column widths according the size of the column headings
            columnWidths[x] = columnNames[x].length();
        }
        // Retrieve data for each row
        while (results.next()) {
            String[] rowData = new String[columnCount];
            for (int x = 0; x < columnCount; x++) {
                rowData[x] = results.getString(x + 1);
                // Check if the column width needs to be adjusted to accommodate this data
                if (rowData[x]!=null && (rowData[x].length() > columnWidths[x])) {
                    columnWidths[x] = rowData[x].length();
                }
            }
            data.add(rowData);
        }
        // Determine the number of rows
        int rowCount = data.size();

        // ------ All data retrieved at this point! ------

        // Construct row separator (for beginning and end of table)
        StringBuilder rowSeparator = new StringBuilder("+");
        for (int columnWidth : columnWidths) {
            rowSeparator.append("-".repeat(columnWidth)).append("+");
        }
        // Display report title
        if (!this.reportTitle.isEmpty()) {
            System.out.println(this.reportTitle);
        }
        // Display a row separator at the beginning of the table
        System.out.println(rowSeparator);
        // Display the headings
        System.out.print("|");
        for (int x = 0; x < columnCount; x++) {
            System.out.printf("%-" + columnWidths[x] + "s|", columnNames[x]);
        }
        System.out.println();
        // Display a row separator after the heading row
        System.out.println(rowSeparator);
        // Display rows
        for (int y = 0; y < rowCount; y++) {
            System.out.print("|");
            for (int x = 0; x < columnCount; x++) {
                String cellData = data.get(y)[x]==null?"":data.get(y)[x];
                System.out.printf("%-" + columnWidths[x] + "s|", cellData);
            }
            System.out.println();
        }
        // Display a row separator at the end of the table
        System.out.println(rowSeparator);
        System.out.println();
    }


    /**
     * Method that will insert parameters obtained from the user into the SQL query.
     * @return
     */
    private String insertParameters() {
        String sqlWithParameters = this.sql;
        // Insert parameters into SQL query using basic string substitution
        for (ReportParameter param : this.reportParameters) {
            sqlWithParameters = sqlWithParameters.replaceAll("%" + param.getName() + "%", param.getValue());
        }
        // Return SQL statement with parameters inserted
        return sqlWithParameters;
    }
}