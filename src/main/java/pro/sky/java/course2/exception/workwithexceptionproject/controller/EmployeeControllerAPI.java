package pro.sky.java.course2.exception.workwithexceptionproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.exception.workwithexceptionproject.domain.EmployeeAPI;
import pro.sky.java.course2.exception.workwithexceptionproject.service.EmployeeService;

import java.util.Collection;

@RequestMapping("/employee")
@RestController
public class EmployeeControllerAPI {
    private final EmployeeService employeeService;

    public EmployeeControllerAPI(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String answerWelcome() {
        return "Welcome to the employee book!";
    }

    @GetMapping("/add")
    public EmployeeAPI add(@RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam int department,
                           @RequestParam int salary) {
        return employeeService.addEmployee(firstName, lastName, department, salary);
    }

    @GetMapping("/remove")
    public EmployeeAPI remove(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public EmployeeAPI find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/get")
    public Collection<EmployeeAPI> get() {
        return employeeService.getEmployees();
    }
}


