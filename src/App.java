import interfaces.ADTListInterface;
import models.Employee;
import models.Node;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {

    public static void main(String[] args) {

//        public static void run() throws Exception {
//            System.out.format("\033[31m%n%s\033[0m%n", "Welcome to the Register App\n" + "===========================\n");
//
//            RegisterController registerController = new RegisterController();
//
//            registerController.run();
//
//            System.out.format("\033[31m%s\033[0m%n", "\n\n===========================================");
//            System.out.format("\033[31m%s\033[0m%n", "Thank you for using Register App. Good bye.");
//        }
//
//        /**
//         * @param args the command line arguments
//         */
//        public static void main(String[] args) throws Exception {
//            RegisterApp registerApp = new RegisterApp();
//            registerApp.run();
//        }

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

        System.out.println("\n---Init list---");
        ADTListInterface<Employee> employeeCircularList = new CircularDoubleLinkedList<>();

        System.out.println("\n---Adding employees to the list---");
        employeeCircularList.insert(emp1);
        employeeCircularList.insert(emp2);
        employeeCircularList.insert(emp3);
        employeeCircularList.insert(emp4);
        employeeCircularList.insert(emp5);

        System.out.println("\n---Printing the list---");
        employeeCircularList.printList();
        System.out.println(employeeCircularList.getLength());

//        System.out.println("---Removing a node from the list---");
//        employeeCircularList.remove(emp3);

        System.out.println("---Finding by phone number---");
        System.out.println(employeeCircularList.findByPhoneNumber(57118407));

        System.out.println("---Checking for qualification---");
        System.out.println(employeeCircularList.findAllByQualification("University Degree"));

        System.out.println("---Find Node---");
        Node<Employee> node = new Node<>(emp3);
//        if (employeeCircularList.findNode(node)) System.out.println("True");
    }

}