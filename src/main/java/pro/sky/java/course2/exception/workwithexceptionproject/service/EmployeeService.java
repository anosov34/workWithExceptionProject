package pro.sky.java.course2.exception.workwithexceptionproject.service;

import pro.sky.java.course2.exception.workwithexceptionproject.Employee;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Collection<Employee> getEmployees();
    Employee findEmployee(String firstName, String lastName);
}
