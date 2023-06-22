package sky.pro.java.homework26.service;

import sky.pro.java.homework26.Department;
import sky.pro.java.homework26.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Department maxSalary(int departmentId);

    Employee minSalary(int departmentId);
    List<Employee> listByDepartment(int departmentId);


    Map<Integer, List<Employee>> getAllByDepartment();
}
