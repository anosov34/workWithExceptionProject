package pro.sky.java.course2.exception.workwithexceptionproject.serviceImpl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.exception.workwithexceptionproject.domain.Employee;
import pro.sky.java.course2.exception.workwithexceptionproject.service.DepartmentService;
import pro.sky.java.course2.exception.workwithexceptionproject.service.EmployeeService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Override
    public Collection<Employee> getAllEmployeesByDepartmentId(Integer department) {
        Stream<Employee> employeeStream = employeeService.getEmployees().stream();
        if (department != null) {
            employeeStream = employeeStream.filter(employee -> employee.getDepartment() == department);
        }
        return employeeStream.sorted(
                Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getFirstName)
                        .thenComparing(Employee::getLastName)

        ).collect(Collectors.toList());
    }
}