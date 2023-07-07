package sky.pro.java.homework26.service;

import org.springframework.stereotype.Service;
import sky.pro.java.homework26.Department;
import sky.pro.java.homework26.exception.EmployeeAlreadyAddedException;
import sky.pro.java.homework26.exception.EmployeeNotFoundException;
import sky.pro.java.homework26.exception.EmployeeStorageIsFullException;
import sky.pro.java.homework26.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Department> employees = new ArrayList<>();

    private final int maxValue = 10;

    @Override
    public Department addEmployee(String firstName, String lastName, int department, double salary) {
        checkInput(firstName, lastName);
        Department newEmployee = new Department(firstName, lastName, department, salary);
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
    public Department deleteEmployee(String firstName, String lastName) {
        checkInput(firstName, lastName);
        Department newEmployee = findEmployee(firstName, lastName);
        for (Department e : employees) {
            if (e.equals(newEmployee)) {
                employees.remove(e);
                return e;
            }
        }
        return newEmployee;
    }


    @Override
    public Department findEmployee(String firstName, String lastName) {
        checkInput(firstName, lastName);
        Department employee = null;
        for (Department e : employees) {
            if (firstName.equals(e.getFirstName()) && lastName.equals(e.getLastName())) {
                return e;
            } else {
                throw new EmployeeNotFoundException("Сотрудник не найден");
            }
        }
        return employee;
    }

    @Override
    public List<Department> showAll () {
        return employees;
    }

    private void checkInput(String firstName, String lastName) {
        if(!(isAlpha(firstName) && isAlpha(lastName))) {
            throw new InvalidInputException();
        };
    }

}
