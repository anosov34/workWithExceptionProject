package pro.sky.java.course2.exception.workwithexceptionproject.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.exception.workwithexceptionproject.domain.EmployeeAPI;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @Override
    public EmployeeAPI getMaxSalaryEmployeeByDep(int department) {
        return employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(EmployeeAPI::getSalary))
                .orElseThrow();
    }

    @Override
    public EmployeeAPI getMinSalaryEmployeeByDep(int department) {
        return employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(EmployeeAPI::getSalary))
                .orElseThrow();
    }

    @Override
    public Collection<EmployeeAPI> getAllEmployeesByDepartmentId(Integer department) {
        Stream<EmployeeAPI> employeeStream = employeeService.getEmployees().stream();
        if (department != null) {
            employeeStream = employeeStream.filter(employee -> employee.getDepartment() == department);
        }
        return employeeStream.sorted(
                Comparator.comparingInt(EmployeeAPI::getDepartment)
                        .thenComparing(EmployeeAPI::getLastName)
                        .thenComparing(EmployeeAPI::getFirstName)
        ).collect(Collectors.toList());
    }
}
