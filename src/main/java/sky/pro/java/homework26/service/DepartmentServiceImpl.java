package sky.pro.java.homework26.service;

import org.springframework.stereotype.Service;
import sky.pro.java.homework26.Department;
import sky.pro.java.homework26.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl (EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Department maxSalary(int departmentId) {
        return employeeService.showAll().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingDouble(e -> e.getSalary()))
                .orElseThrow(() -> new RuntimeException("Не найден"));
    }

    @Override
    public Employee minSalary(int departmentId) {
        return employeeService.showAll().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .min(Comparator.comparingDouble(e -> e.getSalary()))
                .orElseThrow(() -> new RuntimeException("Не найден"));
    }

    @Override
    public List<Employee> listByDepartment(int departmentId) {
        return employeeService.showAll().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }
    @Override
    public Map<Integer, List<Employee>> getAllByDepartment() {
        return employeeService.showAll().stream()
                .collect(Collectors.groupingBy(
                        Department::getDepartmentId, Collectors.toList()
                ));
    }

}
