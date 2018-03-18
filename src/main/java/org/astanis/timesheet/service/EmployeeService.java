package org.astanis.timesheet.service;

import org.astanis.timesheet.model.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    void deleteEmployeeById(long id);

    void updateEmployee(Employee employee);

    Employee readById(long id);

    Employee readByPersonalNumber(long personalNumber);

    List<Employee> readByName(String name);

    List<Employee> readAllByDepartment(String department);

    List<Employee> readAllByGender(boolean gender);

    List<Employee> readAll();
}
