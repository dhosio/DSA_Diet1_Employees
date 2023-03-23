package tests;

import interfaces.ADTListInterface;
import models.Employee;

import java.util.Date;

public class CircularDoubleLinkedListTest {
    // A class to test the functionality of the newly create Circular Double Linked List Class

    public static void main(String[] args) {

        // Test Data
        String firstName = "Daniel";
        String lastName = "Githiomi";
        String address = "Powder Mill Rd, Pamplemousses";
        int telephoneNumber = 57118407;
        String email = "d.githiomi@alustudent.com";
        Date dateJoined = new Date();
        String highestQualification = "University Diploma";

        String firstName1 = "Margaret";
        String lastName1 = "Maina";
        String address1 = "Grand Baie, Mauritius";
        int telephoneNumber1 = 57920512;
        String email1 = "m.maina@alustudent.com";
        Date dateJoined1 = new Date();
        String highestQualification1 = "University Degree";

        // Create new Employee objects
        Employee emp1 = new Employee(firstName, lastName, address, telephoneNumber, email, dateJoined, highestQualification);
        Employee emp2 = new Employee(firstName1, lastName1, address1, telephoneNumber1, email1, dateJoined1, highestQualification1);
        Employee emp3 = new Employee(firstName, lastName, address, telephoneNumber, email, dateJoined, highestQualification);
        Employee emp4 = new Employee(firstName1, lastName1, address1, telephoneNumber1, email1, dateJoined1, highestQualification1);
        Employee emp5 = new Employee(firstName, lastName, address, telephoneNumber, email, dateJoined, highestQualification);


    }
}
