package controller;

import dao.DAOImplementation;
import dao.DAOInterface;
import helpers.InputHelper;
import list.EmployeeList;
import models.Employee;

import java.util.List;

/**
 * @author <a href="mailto:d.githiomi@alustudent.com">Daniel Githiomi</a>
 */
public class Controller {

    // Input Helper to collect user input
    InputHelper inputHelper;

    // Container to hold the elements of the list
    EmployeeList employeeContainer;

    // The DAO Interface
    DAOInterface daoInterface = new DAOImplementation();

    /**
     * Zero argument Controller constructor to initialize the input helper and employee container
     */
    public Controller() {

        // Init the input helper
        inputHelper = new InputHelper();

        // Get the Employee List
        employeeContainer = new EmployeeList();

        char fileReading = Character.toLowerCase(inputHelper.readCharacter("\nAre you loading from an existing file? (Y/N)", "YyNn"));

        switch (fileReading) {
            case 'y':
                String filename = inputHelper.readString("Enter the name of the file");
                List<Employee> retrievedEmployees = daoInterface.load(filename + ".txt");

                for (Employee employee : retrievedEmployees) {
                    employeeContainer.insertFromFile(employee);
                }

                break;
            case 'n':
                break;
        }

        // List all the employees
        employeeContainer.printList();
    }

    /**
     * Initialize the application for the user to use
     */
    public void startApp() {

        boolean quit = false;

        do {

            char menuChoice = showMenu();

            switch (menuChoice) {
                case 'a' -> employeeContainer.printList();
                case 'b' -> createEmployee();
                case 'c' -> removeEmployee();
                case 'd' -> searchByPhoneNumber();
                case 'e' -> searchByLastName();
                case 'f' -> searchByQualification();
                case 'g' -> {
                    quitApp();
                    quit = true;
                }
            }

        } while (!quit);
    }

    /**
     * Provide the user the main menu of actions they could perform in the application
     * @return The user selected character choice
     */
    public char showMenu() {
        // Menu for user to select options from
        System.out.println("""
                \u001B[34m
                A. Show all employees.
                B. Insert a new employee.
                C. Remove an existing employee.
                D. Search by phone number.
                E. Search by last name.
                F. Find all employees with a specific qualification.
                G. Exit application
                \u001B[0m
                """);
        return Character.toLowerCase(inputHelper.readCharacter("Select an option", "AaBbCcDdEeFfGg"));
    }

    /**
     * Get user input and use data to create a new employee object
     */
    public void createEmployee() {
        System.out.format("\u001B[34m%n%s%n\u001B[m", "---Enter new employee details---");

        // Get new employee details from the user
        String firstName = inputHelper.readString("Enter the first name").trim();
        String lastName = inputHelper.readString("Enter the last name").trim();
        String address = inputHelper.readString("Enter " + firstName + "'s address");
        String phoneNumber = inputHelper.readString("Enter " + firstName + "'s phone number");
        String email = inputHelper.readString("Enter " + firstName + "'s email address");
        String qualification = getQualification();

        // Create new employee object
        Employee newEmployee = new Employee(firstName, lastName, address, phoneNumber, email, qualification);

        employeeContainer.insert(newEmployee);
    }

    /**
     * Get the qualification the user wishes to search for
     * @return The string qualification given by the user
     */
    public String getQualification() {
        String qualification = "";

        System.out.println("Choose a level of qualification from the list:");
        System.out.println("""
                \u001B[34m
                A. High School
                B. Diploma
                C. Degree
                D. Masters
                E. PHD
                \u001B[0m
                """);

        char choice = Character.toLowerCase(inputHelper.readCharacter("Select a level of qualification", "AaBbCcDdEe"));

        switch (choice) {
            case 'a' -> qualification = "High School";
            case 'b' -> qualification = "University Diploma";
            case 'c' -> qualification = "Bachelor's Degree";
            case 'd' -> qualification = "Masters Degree";
            case 'e' -> qualification = "PHD";
        }
        return qualification;
    }

    /**
     * Pop an employee from the end of the list
     */
    public void removeEmployee(){
        employeeContainer.remove();
    }

    /**
     * Get a phone number from the user and search for it in the list
     */
    public void searchByPhoneNumber() {

        String phoneNumber = inputHelper.readString("Enter the phone number you want to search for");

        employeeContainer.findByPhoneNumber(phoneNumber);

    }

    /**
     * Get a name from the user and search for it in the list
     */
    public void searchByLastName() {

        String lastName = inputHelper.readString("Enter the last name you want to search for");

        employeeContainer.findByLastName(lastName);

    }

    /**
     * Get a qualification from the user and search for it in the list
     */
    public void searchByQualification() {

        String qualification = inputHelper.readString("Enter the qualification you want to search for");

        employeeContainer.listWithQualification(qualification);

    }

    /**
     * Terminate the running of the controller class
     */
    public void quitApp() {

        System.out.format("\u001B[34m%n%s", "--- Before exiting, please save your progress in a file ---");
        String fileName = inputHelper.readString("Enter the file name");

        daoInterface.store(fileName + ".txt", employeeContainer.getEmployees());
    }
}