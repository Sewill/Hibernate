package HibernateUtil;

import Entity.People;
import Entity.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            if (sessionFactory == null) {
                Configuration configuration = new Configuration().configure("HibernateUtil/hibernate.cfg.xml");
//                 configuration = getConfiguration();
//                configuration.addAnnotatedClass(People.class);
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


    public static Configuration getConfiguration(){
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(People.class);
        cfg.addAnnotatedClass(Phone.class);
        cfg.setProperty("hibernate.connection.url","jdbc:sqlserver://localhost:1433;database=data_base");
        cfg.setProperty("hibernate.connection.driver_class","com.microsoft.sqlserver.jdbc.SQLServerDriver");
        cfg.setProperty("hibernate.connection.username","sa");
        cfg.setProperty("hibernate.connection.password","1");
        cfg.setProperty("hibernate.connection.pool_size","1");
        cfg.setProperty("hibernate.current_session_context_class","thread");
        cfg.setProperty("hibernate.hbm2ddl.auto","update");
        cfg.setProperty("hibernate.show_sql","true");
        cfg.setProperty("hibernate.dialect","org.hibernate.dialect.SQLServerDialect");
        return cfg;
    }
}
