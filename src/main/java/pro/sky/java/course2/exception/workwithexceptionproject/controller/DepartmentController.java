package pro.sky.java.course2.exception.workwithexceptionproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.exception.workwithexceptionproject.domain.Employee;
import pro.sky.java.course2.exception.workwithexceptionproject.service.DepartmentServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping
    public String answerWelcome() {
        return "Welcome to the department book!";
    }

    @GetMapping("/max-salary")
    public Employee showMaxSalaryEmployeeByDep(@RequestParam int department) {
        return departmentService.getMaxSalaryEmployeeByDep(department);
    }

    @GetMapping("/min-salary")
    public Employee showMinSalaryEmployeeByDep(@RequestParam int department) {
        return  departmentService.getMinSalaryEmployeeByDep(department);
    }
    @GetMapping("/all")
    public Collection<Employee> showAllEmployeesByDepartmentId(Integer department) {
        return  departmentService.getAllEmployeesByDepartmentId(department);
    }

}
