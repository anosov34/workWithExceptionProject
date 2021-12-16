package pro.sky.java.course2.exception.workwithexceptionproject.service;

import pro.sky.java.course2.exception.workwithexceptionproject.domain.EmployeeAPI;

import java.util.Collection;


public interface DepartmentService {
    EmployeeAPI getMaxSalaryEmployeeByDep(int department);

    EmployeeAPI getMinSalaryEmployeeByDep(int department);

    Collection<EmployeeAPI> getAllEmployeesByDepartmentId(Integer department);

}
