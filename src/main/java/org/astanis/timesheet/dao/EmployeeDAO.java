package org.astanis.timesheet.dao;

import org.astanis.timesheet.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {
    Employee findByPersonalNumber(long personalNumber);

    List<Employee> findByName(String name);

    List<Employee> findAllByDepartment(String department);

    List<Employee> findAllBySex(boolean sex);
}
