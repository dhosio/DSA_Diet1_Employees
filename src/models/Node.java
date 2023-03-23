package models;

import interfaces.IEmpView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author <a href="mailto:d.githiomi@alustudent.com">Daniel Githiomi</a>
 * @param <Employee> the data type to be stored in each node
 * Implements IEmpView interface
 */

public class Node<Employee> implements IEmpView {

    // The node will have data of type employee
    public Employee nodeValue;

    // A reference to the next node in the list
    public Node<Employee> nextNode;

    // A reference to the previous node in the list
    public Node<Employee> prevNode;

    /**
     * 1 arg constructor to create a new node
     * @param newValue the value to be stored in the node
     */
    public Node(Employee newValue){
        // Create a new node and init its previous and next nodes as null
        this.nodeValue = newValue;
        this.prevNode = null;
        this.nextNode = null;
    }

    /**
     * Display the class information
     */
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
}
