package pro.sky.java.course2.exception.workwithexceptionproject.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.exception.workwithexceptionproject.Employee;

import java.util.Comparator;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getMaxSalaryEmployeeByDep(int department) {
        return employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Employee getMinSalaryEmployeeByDep(int department) {
        return employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }


}
