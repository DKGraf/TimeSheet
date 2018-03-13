package org.astanis.db.dbservice;

import org.astanis.db.datasets.EmployeeDataSet;
import org.astanis.db.datasets.WorkingTimeDataSet;
import org.astanis.db.datasets.dao.EmployeeDataSetDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.function.Function;

public class DbServiceImpl implements IDbService {
    private final SessionFactory sessionFactory;

    public DbServiceImpl() {
        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(EmployeeDataSet.class);
        configuration.addAnnotatedClass(WorkingTimeDataSet.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.username", "dkgraf");
        configuration.setProperty("hibernate.connection.password", "dkgraf");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/timesheet");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");

        sessionFactory = createSessionFactory(configuration);
    }

    @Override
    public void save(EmployeeDataSet employee) {
        try (Session session = sessionFactory.openSession()) {
            EmployeeDataSetDAO dao = new EmployeeDataSetDAO(session);
            dao.save(employee);
        }
    }

    @Override
    public EmployeeDataSet readById(long id) {
        return runInSession(session -> {
            EmployeeDataSetDAO dao = new EmployeeDataSetDAO(session);
            return dao.readById(id);
        });
    }

    @Override
    public EmployeeDataSet readByPersonalNumber(long personalNumber) {
        return runInSession(session -> {
            EmployeeDataSetDAO dao = new EmployeeDataSetDAO(session);
            return dao.readByPersonalNumber(personalNumber);
        });
    }

    @Override
    public List<EmployeeDataSet> readByName(String name) {
        return runInSession(session -> {
            EmployeeDataSetDAO dao = new EmployeeDataSetDAO(session);
            return dao.readByName(name);
        });
    }

    @Override
    public List<EmployeeDataSet> readAll() {
        return runInSession(session -> {
            EmployeeDataSetDAO dao = new EmployeeDataSetDAO(session);
            return dao.readAll();
        });
    }

    @Override
    public List<EmployeeDataSet> readAllByDepartment(String department) {
        return runInSession(session -> {
            EmployeeDataSetDAO dao = new EmployeeDataSetDAO(session);
            return dao.readAllByDepartment(department);
        });
    }

    public List<EmployeeDataSet> readAllByGender(boolean gender) {
        return runInSession(session -> {
            EmployeeDataSetDAO dao = new EmployeeDataSetDAO(session);
            return dao.readAllByGender(gender);
        });
    }

    @Override
    public void shutdown() {
        sessionFactory.close();
    }

    private <R> R runInSession(Function<Session, R> function) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            R result = function.apply(session);
            transaction.commit();
            return result;
        }
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry registry = builder.build();
        return configuration.buildSessionFactory(registry);
    }
}
