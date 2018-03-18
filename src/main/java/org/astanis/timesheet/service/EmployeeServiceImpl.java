package org.astanis.timesheet.service;

import org.astanis.timesheet.dao.EmployeeDAO;
import org.astanis.timesheet.dao.WorkingTimeDAO;
import org.astanis.timesheet.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void saveEmployee(Employee employee) {
        logger.info("---------- saveEmployee()");
        employeeDAO.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        logger.info("---------- deleteEmployee()");
        employeeDAO.delete(employee);
    }

    @Override
    public void deleteEmployeeById(long id) {
        logger.info("---------- deleteEmployeeById()");
        employeeDAO.deleteById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        logger.info("---------- updateEmployee()");
        employeeDAO.save(employee);
    }

    @Override
    public Employee readById(long id) {
        logger.info("---------- readById()");
        return employeeDAO.getOne(id);
    }

    @Override
    public Employee readByPersonalNumber(long personalNumber) {
        logger.info("---------- readByPersonalNumber()");
        return employeeDAO.findByPersonalNumber(personalNumber);
    }

    @Override
    public List<Employee> listByName(String name) {
        logger.info("---------- listByName()");
        return employeeDAO.findByName(name);
    }

    @Override
    public List<Employee> listAllByDepartment(String department) {
        logger.info("---------- listAllByDepartment()");
        return employeeDAO.findAllByDepartment(department);
    }

    @Override
    public List<Employee> listAllByGender(boolean gender) {
        logger.info("---------- listAllByGender()");
        return employeeDAO.findAllByGender(gender);
    }

    @Override
    public List<Employee> listAll() {
        logger.info("---------- listAll()");
        return employeeDAO.findAll();
    }
}
