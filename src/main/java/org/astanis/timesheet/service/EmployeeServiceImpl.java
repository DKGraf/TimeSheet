package org.astanis.timesheet.service;

import org.astanis.timesheet.dao.EmployeeDAO;
import org.astanis.timesheet.dao.WorkingTimeDAO;
import org.astanis.timesheet.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    private final WorkingTimeDAO workingTimeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO, WorkingTimeDAO workingTimeDAO) {
        this.employeeDAO = employeeDAO;
        this.workingTimeDAO = workingTimeDAO;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeDAO.delete(employee);
    }

    @Override
    public void deleteEmployeeById(long id) {
        employeeDAO.deleteById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public Employee readById(long id) {
        return employeeDAO.getOne(id);
    }

    @Override
    public Employee readByPersonalNumber(long personalNumber) {
        return employeeDAO.findByPersonalNumber(personalNumber);
    }

    @Override
    public List<Employee> readByName(String name) {
        return employeeDAO.findByName(name);
    }

    @Override
    public List<Employee> readAllByDepartment(String department) {
        return employeeDAO.findAllByDepartment(department);
    }

    @Override
    public List<Employee> readAllByGender(boolean gender) {
        return employeeDAO.findAllByGender(gender);
    }

    @Override
    public List<Employee> readAll() {
        return employeeDAO.findAll();
    }
}
