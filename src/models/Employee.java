package models;

import interfaces.IEmpView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Objects;

public class Employee implements IEmpView {

    // Employee class variables
    static int numberOfEmployees = 1;
    final char EOLN = '\n';

    // Employee Instance Variables
    public int employeeID;
    public String firstName;
    public String lastName;
    public String address;
    public int telephoneNumber;
    public String email;
    public Date dateJoined;
    public String highestQualification;

    // Zero args constructor
    public Employee(){
        this.employeeID = numberOfEmployees++;
    }

    public Employee(String firstName, String lastName, String address, int telephoneNumber, String email, Date dateJoined, String highestQualification) {
        this.employeeID = numberOfEmployees++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.dateJoined = dateJoined;
        this.highestQualification = highestQualification;
    }

    // Getter and Setter Methods
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getHighestQualification() {
        return highestQualification;
    }

    public void setHighestQualification(String highestQualification) {
        this.highestQualification = highestQualification;
    }

    // Inherited method from the IEmpView interface
    @Override
    public void display() {
        // Method to show relevant information about the class
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

    // To print out the Employee Instance details
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