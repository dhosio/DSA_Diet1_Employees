/**
 * @author <a href="mailto:d.githiomi@alustudent.com">Daniel Githiomi</a>
 * Implements the DAO interface
 * @see dao.DAOInterface
 */

package dao;

import models.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOImplementation implements DAOInterface {

    public static final char DELIMITER = ',';

    /**
     * To persist the list of employees to an external .txt file
     *
     * @param fileName  the name of the file to persist the employees
     * @param employees the list of employees to be persisted
     */
    @Override
    public void store(String fileName, List<Employee> employees) throws Exception {
//
//        try (PrintWriter output = new PrintWriter(fileName)) {
//            output.print(repository.toString(DELIMITER));
//            output.close();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(DAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.format("Error in %s store method. Error: \n" + ex.getMessage(), DAOImplementation.class.getName());
//        }

    }

    /**
     * To retrieve the list of employees from an external .txt file
     *
     * @param fileName the name of the file to retrieve the employees
     * @return a list of employees from the external file
     */
    @Override
    public List<Employee> load(String fileName) {

        // List to store the retrieved employees
        List<Employee> employeesFromList = new ArrayList<Employee>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String[] employeeTempArray;
            String fileLine = br.readLine();

            // Ensure that the line is not empty
            while (fileLine != null) {

                // Split elements of the line at the delimiter and store in string array
                employeeTempArray = fileLine.split(Character.toString(DELIMITER));

                // Create new employee object
                Employee employee;

                // Retrieve array elements
                int employeeId = Integer.parseInt(employeeTempArray[0]);
                String firstName = employeeTempArray[1];
                String lastName = employeeTempArray[2];
                String address = employeeTempArray[3];
                String phoneNumber = employeeTempArray[4];
                String emailAddress = employeeTempArray[5];
                String dateJoined = employeeTempArray[6];
                String highestQualification = employeeTempArray[7];

                // Initialize the employee object with the data
                employee = new Employee(firstName, lastName, address, phoneNumber, emailAddress, dateJoined, highestQualification);

                // Add the employee to the list
                employeesFromList.add(employee);

                // Read the next Line
                fileLine = br.readLine();
            }
            // Close buffered reader
            br.close();

        } catch (Exception ex) {
            Logger.getLogger(DAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
            System.out.format("Error in %s's load method. Error: \n" + ex.getMessage(), DAOImplementation.class.getName());
        }

        if (employeesFromList.size() == 0){
            System.out.println("No employees could be retrieved");
            return null;
        }

        return employeesFromList;
    }
}
