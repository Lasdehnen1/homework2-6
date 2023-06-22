package sky.pro.java.homework26.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.java.homework26.Department;
import sky.pro.java.homework26.Employee;
import sky.pro.java.homework26.service.EmployeeService;

import java.util.List;

@RequestMapping(path = "/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/add")
    public Department addEmployee(@RequestParam(value = "firstName") String firstName,
                                @RequestParam(value = "lastName") String lastName,
                                @RequestParam(value = "department") int department,
                                @RequestParam(value = "salary") double salary) {
        return employeeService.addEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam(value = "firstName") String firstName,
                                   @RequestParam(value = "lastName") String lastName) {

        return employeeService.deleteEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam(value = "firstName") String firstName,
                                 @RequestParam(value = "lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }
    @GetMapping
    public List<Department> showAll() {
        return employeeService.showAll();
    }
}
