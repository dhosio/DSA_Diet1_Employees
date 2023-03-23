package tests;

import models.Employee;

import java.util.Date;

public class EmployeeTest {

    // Test class to test the models.Employee Class Getter and Setter methods
    public static void main(String[] args) {

        // models.Employee Details
        String firstName = "Daniel";
        String lastName = "Githiomi";
        String address = "Powder Mill Rd, Pamplemousses";
        int telephoneNumber = 57118407;
        String email = "d.githiomi@alustudent.com";
        Date dateJoined = new Date();
        String highestQualification = "University Diploma";

        // Create a new employee
        Employee emp = new Employee(firstName, lastName, address, telephoneNumber, email, dateJoined, highestQualification);

        // Get employee details
        getDetails(emp);

        // New details
        String newFirstName = "John";
        String newLastName = "Doe";
        String newAddress = "Vignt Pieds, Grand Baie";
        int newTelephoneNumber = 57920512;
        String newEmail = "johndoe@gmail.com";
        Date newDateJoined = new Date();
        String newHighestQualification = "Master's Degree";

        // Update the employee details
        Employee newEmp = new Employee();
        setDetails(newEmp, newFirstName, newLastName, newAddress, newTelephoneNumber, newEmail, newDateJoined, newHighestQualification);

        // Get employee details after update
        getDetails(newEmp);

        // Get the employee class details
        emp.display();

        // Testing the toString() method for the employee
        System.out.println("\n\nPrinting employee");
        System.out.println(emp);

    }

    public static void getDetails(Employee emp) {
        // To test the employee getter methods
        int empId = emp.getEmployeeID();
        String fName = emp.getFirstName();
        String lName = emp.getLastName();
        String empAddress = emp.getAddress();
        int telNumber = emp.getTelephoneNumber();
        String empEmail = emp.getEmail();
        Date dateJoined = emp.getDateJoined();
        String highestQualification = emp.getHighestQualification();

        System.out.println("-------------------");
        System.out.format("\nEmployee Details: \n\nEmployee ID: %d\nFirst Name: %s\nLast Name: %s\nAddress: %s\nPhone Number: %d\n" + "Email: %s\nDate joined: " + dateJoined + "\nHighest Qualification: %s\n", empId, fName, lName, empAddress, telNumber, empEmail, highestQualification);
    }

    private static void setDetails(Employee emp, String newFirstName, String newLastName, String newAddress, int newTelephoneNumber, String newEmail, Date newDateJoined, String newHighestQualification) {
        // To set new values to the employee fields
        emp.setEmployeeID(20);
        emp.setFirstName(newFirstName);
        emp.setLastName(newLastName);
        emp.setAddress(newAddress);
        emp.setTelephoneNumber(newTelephoneNumber);
        emp.setEmail(newEmail);
        emp.setDateJoined(newDateJoined);
        emp.setHighestQualification(newHighestQualification);
    }

}
