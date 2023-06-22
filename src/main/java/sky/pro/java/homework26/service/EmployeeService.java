package sky.pro.java.homework26.service;

import sky.pro.java.homework26.Department;
import sky.pro.java.homework26.Employee;

import java.util.List;

public interface EmployeeService {


    Department addEmployee(String firstName, String lastName, int department, double salary);

    Employee deleteEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Department> showAll();

}
