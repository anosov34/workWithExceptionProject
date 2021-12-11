package pro.sky.java.course2.exception.workwithexceptionproject.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.exception.workwithexceptionproject.Employee;
import pro.sky.java.course2.exception.workwithexceptionproject.exception.ArraysIsFullException;
import pro.sky.java.course2.exception.workwithexceptionproject.exception.EmployeeIsNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
        employees.add(new Employee("Sergey", "Sergeev"));
        employees.add(new Employee("Ivan", "Ivanov"));
        employees.add(new Employee("Andrey", "Andreyev"));
    }
    @Override
    public boolean addEmployeeVideo(String firstName, String lastName) {
        return employees.add(new Employee(firstName, lastName));
    }

    @Override
    public boolean removeEmployeeVideo(String firstName, String lastName) {
        return employees.remove(new Employee(firstName, lastName));
    }























    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        int index = employees.indexOf(employee);
        if (index == -1) {
            throw new ArraysIsFullException();
        }
        return employees.add(index);
        }


    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
            int index = employees.indexOf(employee);
        if (index == -1) {
            throw new EmployeeIsNotFoundException();
        }
        return employees.remove(index);
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        for (Employee employee : employees) {
            if (employee.equals(employee)) {
                return employee;
            }
        }
        throw new EmployeeIsNotFoundException();
    }



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






