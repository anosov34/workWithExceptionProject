package pro.sky.java.course2.exception.workwithexceptionproject.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.exception.workwithexceptionproject.domain.EmployeeAPI;
import pro.sky.java.course2.exception.workwithexceptionproject.exception.EmployeeIsNotFoundException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImplAPI implements EmployeeService {
    private final Map<String, EmployeeAPI> employees;

    public EmployeeServiceImplAPI() {
        this.employees = new HashMap<>();
    }

    public EmployeeAPI addEmployee(String firstName, String lastName, int department, int salary) {
        EmployeeAPI employeeAPI = new EmployeeAPI(firstName, lastName, department, salary);
        employees.put(firstName + lastName, employeeAPI);
        return employeeAPI;
    }

    public EmployeeAPI removeEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + lastName)) {
            return employees.remove(firstName + lastName);
        }
            throw new EmployeeIsNotFoundException();
    }


    public EmployeeAPI findEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + lastName)) {
            return employees.get(firstName + lastName);
        }
            throw new EmployeeIsNotFoundException();
    }

    public Collection<EmployeeAPI> getEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

}






