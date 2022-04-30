package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.model.User;
import peaksoft.util.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory factory = Util.getSessionFactory();

    @Override
    public void createUsersTable() {
        try (Session session = factory.openSession();) {
            session.beginTransaction();
            session.getTransaction().commit();
            System.out.println("Yeah!!");
        }

    }

    @Override
    public void dropUsersTable() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Query query = session.createSQLQuery("DROP TABLE IF EXISTS users");
            query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("So good!");
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            System.out.println("user saved!!");
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = factory.openSession();) {
            session.getTransaction().begin();
            User user = session.find(User.class, id);
            session.remove(user);
            session.getTransaction().commit();
            System.out.println("user deleted");
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = factory.openSession()) {
            return session.createQuery("SELECT c FROM User c")
                    .getResultList();
        }
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from User ")
                    .executeUpdate();
            session.getTransaction().commit();
            System.out.println("All User delete");
        }
    }

}

