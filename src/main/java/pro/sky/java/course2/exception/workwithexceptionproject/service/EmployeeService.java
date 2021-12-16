package pro.sky.java.course2.exception.workwithexceptionproject.service;

import pro.sky.java.course2.exception.workwithexceptionproject.domain.EmployeeAPI;

import java.util.Collection;

public interface EmployeeService {

    EmployeeAPI addEmployee(String firstName, String lastName, int department, int salary);
    EmployeeAPI removeEmployee(String firstName, String lastName);
    Collection<EmployeeAPI> getEmployees();
    EmployeeAPI findEmployee(String firstName, String lastName);
}
