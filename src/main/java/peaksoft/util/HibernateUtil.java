package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import peaksoft.entity.Workers;

import static org.hibernate.cfg.AvailableSettings.*;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory setUp() {
        Configuration configuration = new Configuration();
        configuration.setProperty(DRIVER, "org.postgresql.Driver");
        configuration.setProperty(URL, "jdbc:postgresql://localhost:5432/postgres");
        configuration.setProperty(USER, "postgres");
        configuration.setProperty(PASS, "admin");
        configuration.setProperty(HBM2DDL_AUTO, "update");
        configuration.setProperty(DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
        configuration.setProperty(SHOW_SQL, "true");
        configuration.addAnnotatedClass(Workers.class);
        sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }
}
