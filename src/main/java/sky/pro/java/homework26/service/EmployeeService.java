package sky.pro.java.homework26.service;

import sky.pro.java.homework26.Employee;


import java.util.Collection;


public interface EmployeeService {


    Employee addEmployee(String firstName, String lastName);

    Employee deleteEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);



    Collection<Employee> showAll();

}
