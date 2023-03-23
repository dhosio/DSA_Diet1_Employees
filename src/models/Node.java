package models;

import interfaces.IEmpView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

// This is the class that will hold the components of a node in the circular double linked list
public class Node<Employee> implements IEmpView {

    // The node will have data of type employee
    public Employee nodeValue;

    // A reference to the next node in the list
    public Node<Employee> nextNode;

    // A reference to the previous node in the list
    public Node<Employee> prevNode;

    // Constructor
    public Node(Employee newValue){
        // Create a new node and init its previous and next nodes as null
        this.nodeValue = newValue;
        this.prevNode = null;
        this.nextNode = null;
    }

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
