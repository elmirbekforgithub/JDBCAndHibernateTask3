package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao{
    @Override
    public void createUsersTable() {
        String sql = "create table if not exists users (" +
                "id serial primary key not null," +
                "name varchar(255) not null," +
                "last_name varchar(255) not null," +
                "age integer not null);";
        try (Statement statement = Util.connection().createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP table if exists users";
        try(Connection connection = Util.connection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        String sql = "insert into users(name,last_name,age) values(?,?,?)";
        try (Connection connection = Util.connection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,name);
            statement.setString(2,lastName);
            statement.setByte(3,age);
            statement.executeUpdate();
        }catch (SQLException s){
            System.out.println(s.getMessage());
        }
    }

    @Override
    public void removeUserById(long id) {
        String SQL = "DELETE FROM users where id = " + String.valueOf(id) + ";";
        try (Connection connection = Util.connection(); PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "select * from users";
        try(Connection connection = Util.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getByte("age"));
                userList.add(user);
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        String sql = "truncate table users";
        try(Connection connection = Util.connection();
            Statement statement = connection.createStatement()) {
            statement.executeQuery(sql);
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
