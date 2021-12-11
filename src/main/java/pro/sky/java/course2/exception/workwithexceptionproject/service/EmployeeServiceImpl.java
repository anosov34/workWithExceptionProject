package pro.sky.java.course2.exception.workwithexceptionproject.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.exception.workwithexceptionproject.Employee;
import pro.sky.java.course2.exception.workwithexceptionproject.exception.ArraysIsFullException;
import pro.sky.java.course2.exception.workwithexceptionproject.exception.EmployeeIsNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employees.add(new Employee(firstName, lastName));
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        int index = employees.indexOf(employee);
        if (index == -1) {
            throw new EmployeeIsNotFoundException();
        }
        return employees.remove(index);
    }
    @Override
    public List<Employee> getEmployees() {
        return employees;
    }



    //    @Override
//    public Employee findEmployee(String firstName, String lastName) {
//        if (employees.contains(firstName + " " + lastName)) {
//            return employees.get();
//        } else {
//            throw new EmployeeIsNotFoundException();
//        }
//    }





//    public EmployeeServiceImpl() {
//        this.employees = new HashMap<>();
//    }
//
//    public Employee addEmployee(String firstName, String lastName) {
//        Employee employee = new Employee(firstName, lastName);
//        employees.put(firstName + " " + lastName, employee);
//        return employee;
//    }
//
//    public Employee removeEmployee(String firstName, String lastName) {
//        if (employees.containsKey(firstName + " " + lastName)) {
//            return employees.remove(firstName + " " + lastName);
//        } else {
//            throw new EmployeeIsNotFoundException();
//        }
//    }
//
//



















//    public Employee addEmployee(String firstName, String lastName) {
//        Employee employee = new Employee(firstName, lastName);
//        int index = employees.indexOf(employee);
//        if (index == -1) {
//            throw new ArraysIsFullException();
//        }
//        return employees.add(index);
//        }



//
//    public Employee findEmployee(String firstName, String lastName) {
//        Employee employee = new Employee(firstName,lastName);
//        for (Employee employee : employees) {
//            if (employee.equals(employee)) {
//                return employee;
//            }
//        }
//        throw new EmployeeIsNotFoundException();
//    }



//        Employee employeeForFind = new Employee(firstName, lastName);
//        for (int i = 0; i < employees.length; i++) {
//            if (employees[i] == null) {
//                continue;
//            }
//            if (employees[i].equals(employeeForFind)) {
//                employees[i] = null;
//                return employeeForFind;
//            }
//        }
//        throw new ;

}






