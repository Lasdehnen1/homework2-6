package sky.pro.java.homework26.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.java.homework26.Employee;
import sky.pro.java.homework26.service.DepartmentService;

import java.util.List;
import java.util.Map;


@RequestMapping(path = "/departments")
@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam(value = "department") int departmentId) {
        return departmentService.maxSalary(departmentId);
    }
    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam(value = "department") int departmentId) {
        return departmentService.minSalary(departmentId);
    }
    @GetMapping(path = "/by-departments")
    public List<Employee> listByDepartment(@RequestParam(value = "department") int departmentId) {
        return departmentService.listByDepartment(departmentId);
    }
    @GetMapping(path="/all")
    public Map<Integer, List<Employee>> getAllByDepartment() {
        return departmentService.getAllByDepartment();
    }


}
