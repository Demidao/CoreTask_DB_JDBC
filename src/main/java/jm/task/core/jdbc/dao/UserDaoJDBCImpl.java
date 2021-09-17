package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.dao.exceptions.DBServiceException;
import jm.task.core.jdbc.dao.exceptions.UtilException;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws DBServiceException {
        try (Statement statement = Util.getConnection().createStatement()) {
            Util.getConnection().setAutoCommit(false);
            String sql = "CREATE TABLE users  " +
                    "( id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR (20) NOT NULL," +
                    "lastName VARCHAR (20) NOT NULL," +
                    "age TINYINT UNSIGNED NOT NULL" +
                    ");";

            statement.executeUpdate(sql);
            Util.getConnection().commit();
            System.out.println("Table users was created successfully");
            Util.getConnection().setAutoCommit(true);
        } catch (Exception exception) {
            throw new DBServiceException(UtilException.BAD_CREATE_USERS_MSG, exception);
        }
    }

    public void dropUsersTable() throws DBServiceException {
        try (Statement statement = Util.getConnection().createStatement()) {
            Util.getConnection().setAutoCommit(false);
            String sql = "DROP TABLE IF EXISTS users;";

            statement.executeUpdate(sql);
            Util.getConnection().commit();
            System.out.println("Table users was dropped successfully");
            Util.getConnection().setAutoCommit(true);
        } catch (Exception exception) {
            throw new DBServiceException(UtilException.BAD_DROP_USERS_MSG, exception);
        }
    }

    public void saveUser(String name, String lastName, byte age) throws DBServiceException {
        try (Statement statement = Util.getConnection().createStatement()) {
            Util.getConnection().setAutoCommit(false);
            String sql = String.format("INSERT INTO users (name, lastName, age) "
                    + " VALUES (\"%s\", \"%s\", \"%d\");", name, lastName, age);

            statement.executeUpdate(sql);
            Util.getConnection().commit();
            System.out.printf("User %s %s was successfully saved.%n", name, lastName);
            Util.getConnection().setAutoCommit(true);
        } catch (Exception exception) {
            throw new DBServiceException(UtilException.BAD_SAVE_USER_MSG, exception);
        }
    }

    public void removeUserById(long id) throws DBServiceException {
        try (Statement statement = Util.getConnection().createStatement()) {
            Util.getConnection().setAutoCommit(false);
            String sql = String.format("DELETE FROM users" +
                    " WHERE id= %d;", id);

            statement.executeUpdate(sql);
            Util.getConnection().commit();
            System.out.printf("User ID %d was successfully removed.\n", id);
            Util.getConnection().setAutoCommit(true);
        } catch (Exception exception) {
            throw new DBServiceException(UtilException.BAD_REMOVE_USER_MSG, exception);
        }
    }

    public List<User> getAllUsers() throws DBServiceException {
        List<User> out = new ArrayList<>();
        try (Statement statement = Util.getConnection().createStatement()) {
            Util.getConnection().setAutoCommit(false);
            String sql = "SELECT * FROM users";
            ResultSet rs = statement.executeQuery(sql);
            Util.getConnection().commit();
            while (rs.next()) {
                long id = rs.getLong(1);
                String name = rs.getString("name");
                String lastName = rs.getString("lastname");
                byte age = rs.getByte(4);
                User user = new User(name, lastName, age);
                user.setId(id);
                out.add(user);
            }
            System.out.printf("Got %d users successfully\n", out.size());
            Util.getConnection().setAutoCommit(true);
        } catch (Exception exception) {
            throw new DBServiceException(UtilException.BAD_GET_ALL_USERS_MSG, exception);
        }
        return out;
    }

    public void cleanUsersTable() throws DBServiceException {

        try {

            List<User> allUsers = getAllUsers();
            for (User user : allUsers) {
                removeUserById(user.getId());
            }
            System.out.printf("All %d users were removed. DB is clean\n", allUsers.size());

        } catch (Exception exception) {
            throw new DBServiceException(UtilException.BAD_CLEAN_USERS_TABLE_MSG, exception);
        }
    }
}
