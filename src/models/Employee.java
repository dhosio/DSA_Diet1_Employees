package models;

import interfaces.IEmpView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Objects;

/**
 * @author <a href="mailto:d.githiomi@alustudent.com">Daniel Githiomi</a>
 * Interface: IEmpView
 */
public class Employee implements IEmpView {

    // Class variables
    static int numberOfEmployees = 1;
    final char EOLN = '\n';

    // Instance variables
    public int employeeID;
    public String firstName;
    public String lastName;
    public String address;
    public String telephoneNumber;
    public String email;
    public Date dateJoined;
    public String highestQualification;

    /**
     * Zero args constructor to create a new employee instance
     */
    public Employee() {
        this.employeeID = numberOfEmployees++;
    }

    /**
     * 6 args constructor to create a new employee
     *
     * @param firstName            the employee's first name
     * @param lastName             the employee's last name
     * @param address              the employee's address
     * @param telephoneNumber      the employee's phone number
     * @param email                the employee's email address
     * @param highestQualification the employee's highest qualification
     */
    public Employee(String firstName, String lastName, String address, String telephoneNumber, String email, String highestQualification) {
        this.employeeID = numberOfEmployees++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.dateJoined = new Date();
        this.highestQualification = highestQualification;
    }

    // Getter and Setter Methods

    /**
     * Get the employee ID
     *
     * @return employee ID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Set the employee ID
     *
     * @param employeeID the employee ID to set
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Get the employee's first name
     *
     * @return the employee's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the employee's first name
     *
     * @param firstName the first name to be set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the employee last name
     *
     * @return the employee's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the employee last name
     *
     * @param lastName the last name to be set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the employee's location address
     *
     * @return the employee's string address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set an address to an employee
     *
     * @param address the address to be set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the employee's phone number
     *
     * @return the employee's string phone number
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * Set a phone number to an employee
     *
     * @param telephoneNumber the phone number to be set
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * Get the employee's email address
     *
     * @return a string of the employee's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the employee's email address
     *
     * @param email the email address to be set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the date the new employee was created or joined
     *
     * @return date object of the date the employee joined
     */
    public Date getDateJoined() {
        return dateJoined;
    }

    /**
     * Set the date an employee was created or joined
     *
     * @param dateJoined the date object to be set
     */
    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    /**
     * Get the employee's highest qualification
     *
     * @return the string of the employee's highest qualification
     */
    public String getHighestQualification() {
        return highestQualification;
    }

    /**
     * Set the employee's highest qualification
     *
     * @param highestQualification the highest qualification to be set
     */
    public void setHighestQualification(String highestQualification) {
        this.highestQualification = highestQualification;
    }

    /**
     * Method inherited method from the IEmpView interface
     * To display information of the employee class
     */
    @Override
    public void display() {
        // Get relevant class information
        String className = this.getClass().getName();
        Field[] variables = this.getClass().getDeclaredFields();
        Method[] methods = this.getClass().getDeclaredMethods();

        int fCounter = 1, mCounter = 1;

        System.out.format("\nYou are currently using the %s class. \nIt has the following variables: \n", className);
        for (Field field : variables) {
            System.out.println(fCounter + ". " + field.getName());
            fCounter++;
        }
        System.out.println("\nAnd the following methods: ");
        for (Method method : methods) {
            System.out.println(mCounter + ". " + method.getName() + "()");
            mCounter++;
        }
    }

    /**
     * Print out the string representation of an employee object
     *
     * @return a string summary of the employee instance
     */
    @Override
    public String toString() {
        return "\n-----------------------------" + EOLN +
                "Employee ID: " + this.employeeID + EOLN +
                "First Name: " + this.firstName + EOLN +
                "Last Name: " + this.lastName + EOLN +
                "Address: " + this.address + EOLN +
                "Phone Number: " + this.telephoneNumber + EOLN +
                "Email: " + this.email + EOLN +
                "Date joined: " + dateJoined + EOLN +
                "Highest Qualification: " + this.highestQualification + EOLN;

    }

    // To compare different Employee instances - Based on ID only
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return employeeID == employee.employeeID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID);
    }
}