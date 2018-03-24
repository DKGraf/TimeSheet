package org.astanis.timesheet.service;

import org.astanis.timesheet.dao.EmployeeDAO;
import org.astanis.timesheet.dao.WorkingMonthDAO;
import org.astanis.timesheet.model.Employee;
import org.astanis.timesheet.model.WorkingMonth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    private WorkingMonthDAO workingMonthDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO, WorkingMonthDAO workingMonthDAO) {
        this.employeeDAO = employeeDAO;
        this.workingMonthDAO = workingMonthDAO;
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
        Optional<Employee> opt = employeeDAO.findById(id);
        return opt.orElse(null);
    }

    @Override
    public Employee readByPersonalNumber(long personalNumber) {
        return employeeDAO.findByPersonalNumber(personalNumber);
    }

    @Override
    public List<Employee> listByName(String name) {
        return employeeDAO.findByName(name);
    }

    @Override
    public List<Employee> listAllByDepartment(String department) {
        return employeeDAO.findAllByDepartment(department);
    }

    @Override
    public List<Employee> listAllBySex(boolean sex) {
        return employeeDAO.findAllBySex(sex);
    }

    @Override
    public List<Employee> listAll() {
        return employeeDAO.findAll();
    }

    @Override
    public List<WorkingMonth> listAllByYearAndMonth(int year, int month) {
        return workingMonthDAO.findAllByYearAndMonth(year, month);
    }
}
