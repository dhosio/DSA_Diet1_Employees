import interfaces.ADTListInterface;
import models.Employee;
import models.Node;

import java.util.ArrayList;
import java.util.List;

public class CircularDoubleLinkedList<T> implements ADTListInterface<Employee> {

    // Class List variables
    public static int length;
    public Node<Employee> head;
    public Node<Employee> tail;

    // Class constructor
    public CircularDoubleLinkedList() {
        length = 0;
        head = null;
        tail = null;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return head == null || length == 0;
    }

    @Override
    public Employee findNode(int nodeID) {
        // Counter to keep track of the list elements
        int counter = 0;

        if (!isEmpty()) {

            // Create a temp node
            Node<Employee> current = head;

            while (current.nextNode != null) {

                // Check if the data matches
                if (current.nodeValue.employeeID == nodeID) {
                    return current.nodeValue;
                }

                // If not matched, move to the next node
                current = current.nextNode;
                counter++;

                if (counter == getLength()) return null;

            }
        }
        System.out.println("Could not find node in the list");
        return null;
    }

    @Override
    public void printList() {
        Node<Employee> current = head;

        if (isEmpty()) System.out.println("\n\n--- The list is empty ---\n\n");

        // Traverse the list
        while (current != null){
            System.out.println(current.nodeValue);
            current = current.nextNode;
        }

        // End of the list
        System.out.println("\n\n--- End of the list ---\n\n");
    }

    @Override
    public void insert(Employee newNodeVal) {
        // Create the new node
        Node<Employee> createdNode = new Node<>(newNodeVal);

        // Check if the list is empty
        if (isEmpty()){
            // Then new node is the head node
            head = createdNode;
            // Because it is also the last node
            tail = head;
            length++;
            return;
        }
        // If there are other elements
        createdNode.nextNode = head;
        head = createdNode;
        length++;
    }

    @Override
    public Employee remove(Employee toRemove) {
        // To remove the fist element in the list
        if (isEmpty()){
            System.out.println("Cannot remove from an empty list");
            return null;
        }

        Node<Employee> current = head;

        while (current != null){
            // Check if the employee values match
            if (current.nodeValue == toRemove){

                // Check the position of the node
                if ( current == head ){
                    // If node is at start
                    Node<Employee> temp = head;
                    head = head.nextNode;
                    temp.nextNode = null;
                }

                if ( current == tail ){
                    // If node is at the end
                    Node<Employee> temp = tail;
                    tail = temp.prevNode;
                    temp.prevNode = null;
                }else{
                    // Not at the start or at the end
                    Node<Employee> tempNext = current.nextNode;
                    Node<Employee> tempPrev = current.prevNode;

                    tempPrev.nextNode = tempNext;
                    tempNext.prevNode = tempPrev;
                }

                // Reduce the length
                length--;

            }
            current = current.nextNode;
        }

        // Check if list is empty
        if (isEmpty()) {
            head = null;
            tail  = null;
            length = 0; // Reset length to 0
        }

        return null;
    }

    @Override
    public Employee findByPhoneNumber(int phoneNumber) {

        // Check if the list is empty
        if (isEmpty()) {
            System.out.println("There are employees in the list");
            return null;
        }

        // Traverse the node to find a node that matches the phone number
        Node<Employee> current = head;

        while (current != null){
            // Check if the phone numbers match
            if (current.nodeValue.telephoneNumber == phoneNumber){
                return current.nodeValue;
            }else{
                current = current.nextNode;
            }
        }

        return null;
    }

    @Override
    public Employee findByLastName(String lastName) {
        // Traverse the list
        if (isEmpty()){
            System.out.println("There are employees in the list");
            return null;
        }

        // Traverse the list to compare last names
        Node<Employee> current = head;

        while (current != null){
            // Check if last names match
            if ( current.nodeValue.lastName.equals(lastName) ){
                return current.nodeValue;
            }else{
                current = current.nextNode;
            }
        }

        return null;
    }

    @Override
    public List<Employee> findAllByQualification(String qualification) {

        // Create list to hold all relevant employees
        List<Employee> employees = new ArrayList<>();

        Node<Employee> current = head;

        while ( current != null ){
            // Check if the qualifications match
            if ( current.nodeValue.highestQualification.toLowerCase().equalsIgnoreCase(qualification) ){
                // If the qualifications match, add the employee to the list
                employees.add(current.nodeValue);
            }
            current = current.nextNode;
        }

        if (employees.size() == 0){
            System.out.println("There are no employees that match the given qualification");
        }

        return employees;
    }
}
