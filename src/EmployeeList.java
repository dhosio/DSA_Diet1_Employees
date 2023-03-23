import interfaces.ADTListInterface;
import models.Employee;

import java.util.List;

public class EmployeeList {

    // To hold the list of employees
    ADTListInterface<Employee> employeeList = new CircularDoubleLinkedList<>();

    // Inserting a new employee to the list
    public void insert(Employee employee) {
        employeeList.insert(employee);
        System.out.println("Successfully inserted new employee into the list!");
    }

    // To remove an employee from the list
    public void removeFromList(int employeeID) {
        // Find the specific employee
        Employee toRemove = employeeList.findNode(employeeID);

        if (toRemove != null) {
            employeeList.remove(toRemove);
            System.out.println("Removed employee with the ID " + employeeID);
        }

        System.out.println("Could not find employee with the ID " + employeeID);
    }

    // Get employee with a given phone number
    public void findByPhoneNumber(String phoneNumber) {

        // Change the phone number to int
        int number = Integer.parseInt(phoneNumber);

        Employee found = employeeList.findByPhoneNumber(number);

        if (found != null) {
            System.out.println("\nFound an employee with the number: " + number);
            System.out.println(found);
            return;
        }

        System.out.println("\nCould not find an employee with the number " + number);
    }

    // Get employee with a given last name
    public void findByLastName(String lastName) {

        Employee found = employeeList.findByLastName(lastName);

        if (found != null) {
            System.out.println("\nFound an employee with the last name: " + lastName);
            System.out.println(found);
            return;
        }

        System.out.println("\nCould not find an employee with the last name " + lastName);
    }

    // Get a list of all the employees with a given qualification
    public void listWithQualification(String levelOfQualification) {

        List<Employee> list = employeeList.findAllByQualification(levelOfQualification);

        if (!list.isEmpty()) {
            System.out.println("Found " + list.size() + " employees with the given qualification: " + levelOfQualification);

            for (Employee employee : list) {
                System.out.println(employee);
            }

        }

    }
}
