package pro.sky.java.course2.exception.workwithexceptionproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.exception.workwithexceptionproject.service.EmployeeService;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String answerWelcome() {
        return "Welcome to the employee book!";
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam String firstName, String lastName) {
        employeeService.addEmployee(firstName,lastName);
        return "Employee " + firstName + " " + lastName + " added successfully";
    }
    @GetMapping(path = "/remove")
    public String remove(@RequestParam String firstName, String lastName) {
        employeeService.removeEmployee(firstName,lastName);
        return "Employee " + firstName + " " + lastName + " removed successfully";
    }
    @GetMapping(path = "/find")
    public String find(@RequestParam String firstName, String lastName) {
        employeeService.findEmployee(firstName,lastName);
        return "firstName: " + firstName + " lastName: " + lastName;
    }


}

