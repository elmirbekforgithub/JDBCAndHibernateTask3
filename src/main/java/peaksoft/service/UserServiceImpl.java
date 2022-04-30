package peaksoft.service;

import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
     UserDaoHibernateImpl hibernate = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() {
        hibernate.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        hibernate.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        hibernate.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        hibernate.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return hibernate.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        hibernate.cleanUsersTable();
    }
}
