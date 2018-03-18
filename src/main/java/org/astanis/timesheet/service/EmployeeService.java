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

    List<Employee> listByName(String name);

    List<Employee> listAllByDepartment(String department);

    List<Employee> listAllByGender(boolean gender);

    List<Employee> listAll();
}
