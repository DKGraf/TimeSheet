package org.astanis.db.dbservice;

import org.astanis.db.datasets.EmployeeDataSet;

public interface IDbService {
    void save(EmployeeDataSet employee);

    EmployeeDataSet load(long id);

    void shutdown();
}
