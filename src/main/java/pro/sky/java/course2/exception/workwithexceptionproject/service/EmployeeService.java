package pro.sky.java.course2.exception.workwithexceptionproject.service;

import pro.sky.java.course2.exception.workwithexceptionproject.domain.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int department, int salary);
    Employee removeEmployee(String firstName, String lastName);
    Collection<Employee> getEmployees();
    Employee findEmployee(String firstName, String lastName);
}
