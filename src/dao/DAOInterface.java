/**
 * @author <a href="mailto:d.githiomi@alustudent.com">Daniel Githiomi</a>
 * Interface that holds the methods to be implemented to extract and store data
 */
package dao;

import models.Employee;

import java.util.List;

public interface DAOInterface {

    void store(String fileName, List<Employee> employees);

    List<Employee> load(String fileName);

}
