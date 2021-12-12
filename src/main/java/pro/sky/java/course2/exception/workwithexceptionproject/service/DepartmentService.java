package pro.sky.java.course2.exception.workwithexceptionproject.service;

import pro.sky.java.course2.exception.workwithexceptionproject.Employee;

public interface DepartmentService {
    Employee getMaxSalaryEmployeeByDep(int department);
    Employee getMinSalaryEmployeeByDep(int department);

}
