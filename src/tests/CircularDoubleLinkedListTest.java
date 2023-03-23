package tests;

import list.EmployeeList;
import models.Employee;

import java.util.Date;

/**
 * Class to test the functionality of the newly create Circular Double Linked List Class
 */
public class CircularDoubleLinkedListTest {

    public static void main(String[] args) {

        // Test Data
        String firstName = "Daniel";
        String lastName = "Githiomi";
        String address = "Powder Mill Rd, Pamplemousses";
        String telephoneNumber = "57118407";
        String email = "d.githiomi@alustudent.com";
        Date dateJoined = new Date();
        String highestQualification = "University Diploma";

        String firstName1 = "Margaret";
        String lastName1 = "Maina";
        String address1 = "Grand Baie, Mauritius";
        String telephoneNumber1 = "57920512";
        String email1 = "m.maina@alustudent.com";
        Date dateJoined1 = new Date();
        String highestQualification1 = "University Degree";

        // Create new Employee objects
        Employee emp1 = new Employee(firstName, lastName, address, telephoneNumber, email, highestQualification);
        Employee emp2 = new Employee(firstName1, lastName1, address1, telephoneNumber1, email1, highestQualification1);
        Employee emp3 = new Employee(firstName, lastName, address, telephoneNumber, email, highestQualification);
        Employee emp4 = new Employee(firstName1, lastName1, address1, telephoneNumber1, email1, highestQualification1);
        Employee emp5 = new Employee(firstName, lastName, address, telephoneNumber, email, highestQualification);

        // Create the employee list
        EmployeeList employeeList = new EmployeeList();

        // Check if the list exists and is empty
        System.out.println("List length: --- " + employeeList.listLength());

        // Add employees to the list
        employeeList.insert(emp1);
        employeeList.insert(emp2);
        employeeList.insert(emp3);
        employeeList.insert(emp4);
        employeeList.insert(emp5);

        // Print list after adding
        employeeList.printList();

        // Remove an employee from the list
        employeeList.remove();

        // Print the new list
        employeeList.printList();

        // Find an employee by their phone number
        String number = "57118407";
        employeeList.findByPhoneNumber(number);

        // Find an employee by their last name
        String lName = "Maina";
        employeeList.findByLastName(lName);

        // Find employees by their highest qualification
        String qualification = "University Degree";
        employeeList.listWithQualification(qualification);

    }
}
