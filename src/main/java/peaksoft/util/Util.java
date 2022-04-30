package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        sessionFactory = new Configuration()
                .setProperty(Environment.DRIVER, "org.postgresql.Driver")
                .setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres")
                .setProperty(Environment.USER,"postgres")
                .setProperty(Environment.PASS,"1234")
                .setProperty(Environment.HBM2DDL_AUTO, "validate")
                .setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL10Dialect")
                .setProperty(Environment.SHOW_SQL, "true")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        entityManager = sessionFactory.createEntityManager();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static Connection connection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/postgres", "postgres","1234");
        }catch (SQLException sqlException){
            System.out.println(sqlException);
        }
        return conn;
    }
}

