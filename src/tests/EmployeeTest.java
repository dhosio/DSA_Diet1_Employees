package tests;

import models.Employee;

import java.util.Date;

/**
 * Test class to test the Employee Class Getter and Setter methods
 */
public class EmployeeTest {
    public static void main(String[] args) {

        // models.Employee Details
        String firstName = "Daniel";
        String lastName = "Githiomi";
        String address = "Powder Mill Rd, Pamplemousses";
        String telephoneNumber = "57118407";
        String email = "d.githiomi@alustudent.com";
        String highestQualification = "University Diploma";

        // Create a new employee
        Employee emp = new Employee(firstName, lastName, address, telephoneNumber, email, highestQualification);

        // Get employee details
        getDetails(emp);

        // New details
        String newFirstName = "John";
        String newLastName = "Doe";
        String newAddress = "Vignt Pieds, Grand Baie";
        String newTelephoneNumber = "57920512";
        String newEmail = "johndoe@gmail.com";
        Date newDateJoined = new Date();
        String newHighestQualification = "Master's Degree";

        // Update the employee details
        Employee newEmp = new Employee();
        setDetails(newEmp, newFirstName, newLastName, newAddress, newTelephoneNumber, newEmail, newHighestQualification);

        // Get employee details after update
        getDetails(newEmp);

        // Get the employee class details
        emp.display();

        // Testing the toString() method for the employee
        System.out.println("\n\nPrinting employee");
        System.out.println(emp);

    }

    /**
     * Get employee details
     * @param emp the employee instance to get details of
     */
    public static void getDetails(Employee emp) {
        // To test the employee getter methods
        int empId = emp.getEmployeeID();
        String fName = emp.getFirstName();
        String lName = emp.getLastName();
        String empAddress = emp.getAddress();
        String telNumber = emp.getTelephoneNumber();
        String empEmail = emp.getEmail();
        Date dateJoined = emp.getDateJoined();
        String highestQualification = emp.getHighestQualification();

        System.out.println("-------------------");
        System.out.format("\nEmployee Details: \n\nEmployee ID: %d\nFirst Name: %s\nLast Name: %s\nAddress: %s\nPhone Number: %d\n" + "Email: %s\nDate joined: " + dateJoined + "\nHighest Qualification: %s\n", empId, fName, lName, empAddress, telNumber, empEmail, highestQualification);
    }

    /**
     * Set employee details
     * @param emp the employee instance to set values to
     * @param newFirstName the first name of the employee
     * @param newLastName the last name of the employee
     * @param newAddress the address of the employee
     * @param newTelephoneNumber the telephone number of the employee
     * @param newEmail the email address of the employee
     * @param newHighestQualification the employee's highest qualification
     */
    private static void setDetails(Employee emp, String newFirstName, String newLastName, String newAddress, String newTelephoneNumber, String newEmail, String newHighestQualification) {
        // To set new values to the employee fields
        emp.setEmployeeID(20);
        emp.setFirstName(newFirstName);
        emp.setLastName(newLastName);
        emp.setAddress(newAddress);
        emp.setTelephoneNumber(newTelephoneNumber);
        emp.setEmail(newEmail);
        emp.setDateJoined(new Date());
        emp.setHighestQualification(newHighestQualification);
    }

}
