package interfaces;

import java.util.List;

/**
 * The interface that will hold the methods to be inherited by the circular linked list class
 * @param <Employee> the type of data the list should contain
 */
public interface ADTListInterface<Employee> {

    /**
     * Get the number of all employees in the list
     * @return the int length of the list
     */
    int getLength();

    /**
     * Check if the list is empty or if it contains any elements
     * @return true if the list contains elements, false otherwise
     */
    boolean isEmpty();

    /**
     * Print out the contents of the list
     * @return array list containing the elements of the list
     */
    List<Employee> getList();

    /**
     * Add a new element to the end of the list
     * @param newNodeVal the new element instance to be added to the list
     */
    void insert(Employee newNodeVal);

    /**
     * Remove an element from the list
     * @return the element instance popped from the list
     */
    Employee remove();

    /**
     * Find an element in the list by their Phone Number
     * @param phoneNumber the phone number to search for in the list
     * @return the element instance that matches the phone number
     */
    Employee findByPhoneNumber(String phoneNumber);

    /**
     * Find an element in the list by their last name
     * @param lastName the last name to search for in the list
     * @return the element instance that matches the last name
     */
    Employee findByLastName(String lastName);

    /**
     * Find an element in the list by their highest qualification
     * @param qualification the qualification string to search for in the list
     * @return the element instance that matches the given qualification
     */
    List<Employee> findAllByQualification(String qualification);

}