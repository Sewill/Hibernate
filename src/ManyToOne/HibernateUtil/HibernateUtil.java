package ManyToOne.HibernateUtil;

import ManyToOne.Entity.People;
import ManyToOne.Entity.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            if (sessionFactory == null) {
                Configuration configuration = getConfiguration();
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            }
            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }


    public static Configuration getConfiguration() {
        Configuration cfg = new Configuration();

        cfg.addAnnotatedClass(People.class);
        cfg.addAnnotatedClass(Phone.class);
//        cfg.addAnnotatedClass(ManyToOne.Entity.Maximum.People.class);
//        cfg.addAnnotatedClass(ManyToOne.Entity.Maximum.Phone.class);
//        cfg.addAnnotatedClass(ManyToOne.Entity.Medium.People.class);
//        cfg.addAnnotatedClass(ManyToOne.Entity.Medium.Phone.class);

        cfg.setProperty("hibernate.connection.url", "jdbc:sqlserver://localhost:1433;database=data_base");
        cfg.setProperty("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        cfg.setProperty("hibernate.connection.username", "sa");
        cfg.setProperty("hibernate.connection.password", "1");
        cfg.setProperty("hibernate.connection.pool_size", "1");
        cfg.setProperty("hibernate.current_session_context_class", "thread");
        cfg.setProperty("hibernate.hbm2ddl.auto", "update");
        cfg.setProperty("hibernate.show_sql", "true");
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        return cfg;
    }
}
