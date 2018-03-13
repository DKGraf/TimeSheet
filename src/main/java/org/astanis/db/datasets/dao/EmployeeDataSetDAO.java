package org.astanis.db.datasets.dao;

import org.astanis.db.datasets.EmployeeDataSet;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        final Root<EmployeeDataSet> root = criteria.from(EmployeeDataSet.class);
        criteria.where(builder.equal(root.get("personalNumber"), personalNumber));
        Query<EmployeeDataSet> query = session.createQuery(criteria);
        return query.uniqueResult();
    }

    public EmployeeDataSet readByName(String name) {
        return null;
    }

    public EmployeeDataSet readByDepartment(String department) {
        return null;
    }

    public List<EmployeeDataSet> readAll() {
        return null;
    }

    public List<EmployeeDataSet> readAllByDepartment(String department) {
        return null;
    }

    public List<EmployeeDataSet> readAllByGender(boolean gender) {
        return null;
    }
}
