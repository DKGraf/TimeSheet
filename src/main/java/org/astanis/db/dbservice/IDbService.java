package org.astanis.db.dbservice;

import org.astanis.db.datasets.EmployeeDataSet;

import java.util.List;

public interface IDbService {
    void save(EmployeeDataSet employee);

    EmployeeDataSet readById(long id);

    EmployeeDataSet readByPersonalNumber(long personalNumber);

    EmployeeDataSet readByName(String name);

    EmployeeDataSet readByDepartment(String department);

    List<EmployeeDataSet> readAll();

    List<EmployeeDataSet> readAllByDepartment(String department);

    List<EmployeeDataSet> readAllByGender(boolean gender);

    void shutdown();
}
