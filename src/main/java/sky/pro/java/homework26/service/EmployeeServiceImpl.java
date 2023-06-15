package sky.pro.java.homework26.service;

import org.springframework.stereotype.Service;
import sky.pro.java.homework26.Employee;
import sky.pro.java.homework26.exception.EmployeeAlreadyAddedException;
import sky.pro.java.homework26.exception.EmployeeNotFoundException;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>();



    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.containsKey(newEmployee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
        }

        employees.put(newEmployee.getFullName(), newEmployee);
        return newEmployee;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.containsKey(newEmployee.getFullName())) {
            employees.remove(newEmployee.getFullName());
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return newEmployee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.containsKey(newEmployee.getFullName())) {
            return newEmployee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }



    @Override
    public Collection<Employee> showAll() {
        return employees.values();
    }
}
