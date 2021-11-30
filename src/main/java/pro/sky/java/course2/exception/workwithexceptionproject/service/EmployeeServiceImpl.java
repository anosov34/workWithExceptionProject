package pro.sky.java.course2.exception.workwithexceptionproject.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.exception.workwithexceptionproject.exception.ArraysIsFullException;
import pro.sky.java.course2.exception.workwithexceptionproject.Employee;
import pro.sky.java.course2.exception.workwithexceptionproject.exception.EmployeeIsNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Employee[] employees = new Employee[1];


    public Employee addEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(firstName, lastName);
                return employees[i];
            }
        }
        throw new ArraysIsFullException();
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employeeForRemove = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].equals(employeeForRemove)) {
                employees[i] = null;
                return employees[i];
            }
        }
        throw new EmployeeIsNotFoundException();
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employeeForFind = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].equals(employeeForFind)) {
                employees[i] = null;
                return employeeForFind;
            }
        }
        throw new EmployeeIsNotFoundException();
    }
}






