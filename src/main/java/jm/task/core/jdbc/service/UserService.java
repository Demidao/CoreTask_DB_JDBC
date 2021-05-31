package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.exceptions.DBServiceException;
import jm.task.core.jdbc.model.User;

import java.util.List;

public interface UserService {
    void createUsersTable() throws DBServiceException;

    void dropUsersTable() throws DBServiceException;

    void saveUser(String name, String lastName, byte age) throws DBServiceException;

    void removeUserById(long id) throws DBServiceException;

    List<User> getAllUsers() throws DBServiceException;

    void cleanUsersTable() throws DBServiceException;
}
