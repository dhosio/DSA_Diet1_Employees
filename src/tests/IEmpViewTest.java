package tests;

import interfaces.IEmpView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class IEmpViewTest implements IEmpView {

    @Override
    public void display() {
        // Method to show relevant information about the class

        String className = IEmpViewTest.class.getName();
        Field[] variables = this.getClass().getDeclaredFields();
        Method[] methods = this.getClass().getDeclaredMethods();

        System.out.format("You are currently using the %s class. It has the following variables: \n", className);
        for (Field field : variables){
            System.out.println(field.getName());
        }
        System.out.println("And the following methods: ");
        for (Method method : methods){
            System.out.println(method.getName() + "()");
        }

    }

    // Testing the IEmpViewTest class that implements the IEmpView interface
    public static void main(String[] args) {

        IEmpViewTest iEmpViewTest = new IEmpViewTest();
        iEmpViewTest.display();

    }
}
