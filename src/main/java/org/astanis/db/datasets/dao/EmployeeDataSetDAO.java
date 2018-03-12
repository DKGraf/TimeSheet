package org.astanis.db.datasets.dao;

import org.astanis.db.datasets.EmployeeDataSet;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class EmployeeDataSetDAO {
    private Session session;

    public EmployeeDataSetDAO(Session session) {
        this.session = session;
    }

    public void save(EmployeeDataSet employee) {
        session.saveOrUpdate(employee);
    }

    public EmployeeDataSet readById(long id) {
        return session.get(EmployeeDataSet.class, id);
    }

    public EmployeeDataSet readByPersonalNumber(long personalNumber) {
        final CriteriaBuilder builder = session.getCriteriaBuilder();
        final CriteriaQuery<EmployeeDataSet> criteria = builder.createQuery(EmployeeDataSet.class);

    }

    public EmployeeDataSet readByName(String name) {

    }

    public EmployeeDataSet readByDepartment(String department) {

    }

    public List<EmployeeDataSet> readAll() {

    }

    public List<EmployeeDataSet> readAllByDepartment(String department) {

    }

    public List<EmployeeDataSet> readAllByGender(boolean gender) {

    }
}
