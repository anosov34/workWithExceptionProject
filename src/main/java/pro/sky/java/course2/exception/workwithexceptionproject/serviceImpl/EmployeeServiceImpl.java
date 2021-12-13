package pro.sky.java.course2.exception.workwithexceptionproject.serviceImpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.exception.workwithexceptionproject.domain.Employee;
import pro.sky.java.course2.exception.workwithexceptionproject.exception.EmployeeIsNotFoundException;
import pro.sky.java.course2.exception.workwithexceptionproject.exception.StringIncorrectException;
import pro.sky.java.course2.exception.workwithexceptionproject.service.EmployeeService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    public Employee addEmployee(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        employees.put(firstName + lastName, employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + lastName)) {
            return employees.remove(firstName + lastName);
        } else {
            throw new EmployeeIsNotFoundException();
        }
    }

    public Employee findEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + lastName)) {
            return employees.get(firstName + lastName);
        } else {
            throw new EmployeeIsNotFoundException();
        }
    }
    public Collection<Employee> getEmployees() {
        return employees.values();
    }
}