package org.astanis.db.dbservice;

import org.astanis.db.datasets.EmployeeDataSet;
import org.astanis.db.datasets.WorkingTimeDataSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

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

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry registry = builder.build();
        return configuration.buildSessionFactory(registry);
    }

    @Override
    public void save(EmployeeDataSet employee) {
        try (Session session = sessionFactory.openSession()) {
            session.save(employee);
        }
    }

    @Override
    public EmployeeDataSet load(long id) {
        EmployeeDataSet employee;
        try (Session session = sessionFactory.openSession()) {
            employee = session.get(EmployeeDataSet.class, id);
        }
        return employee;
    }

    @Override
    public void shutdown() {
        sessionFactory.close();
    }
}
