package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.dao.exceptions.DBServiceException;
import jm.task.core.jdbc.model.User;

import java.util.List;

public interface UserDao {
    void createUsersTable() throws DBServiceException;

    void dropUsersTable() throws DBServiceException;

    void saveUser(String name, String lastName, byte age) throws DBServiceException;

    void removeUserById(long id) throws DBServiceException;

    List<User> getAllUsers() throws DBServiceException;

    void cleanUsersTable() throws DBServiceException;
}
