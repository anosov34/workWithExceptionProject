package pro.sky.java.course2.exception.workwithexceptionproject.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.exception.workwithexceptionproject.exception.ArraysIsFullException;
import pro.sky.java.course2.exception.workwithexceptionproject.Employee;
import pro.sky.java.course2.exception.workwithexceptionproject.exception.EmployeeIsNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employees.put(firstName + " " + lastName, employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + " " + lastName)) {
            return employees.remove(firstName + " " + lastName);
        } else {
            throw new EmployeeIsNotFoundException();
        }
    }


    public Employee findEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + " " + lastName)) {
            return employees.get(firstName + " " + lastName);
        } else {
            throw new EmployeeIsNotFoundException();
        }
    }
}






