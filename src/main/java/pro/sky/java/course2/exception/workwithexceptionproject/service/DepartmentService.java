package pro.sky.java.course2.exception.workwithexceptionproject.service;

import pro.sky.java.course2.exception.workwithexceptionproject.domain.Employee;

import java.util.Collection;


public interface DepartmentService {
    Employee getMaxSalaryEmployeeByDep(int department);

    Employee getMinSalaryEmployeeByDep(int department);

    Collection<Employee> getAllEmployeesByDepartmentId(Integer department);

}
