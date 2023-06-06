package sky.pro.java.homework26.service;

import org.springframework.stereotype.Service;
import sky.pro.java.homework26.Employee;
import sky.pro.java.homework26.exception.EmployeeAlreadyAddedException;
import sky.pro.java.homework26.exception.EmployeeNotFoundException;
import sky.pro.java.homework26.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees = new ArrayList<>();
    private final int maxValue = 2;

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.size() == maxValue) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме");
        }
        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
        }
        employees.add(newEmployee);
        return newEmployee;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.contains(newEmployee)) {
            employees.remove(newEmployee);
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return newEmployee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.contains(newEmployee)) {
            return newEmployee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    @Override
    public List<Employee> showAll() {
        return employees;
    }
}
