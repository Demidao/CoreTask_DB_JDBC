package jm.task.core.jdbc.util;

import jm.task.core.jdbc.dao.exceptions.DBServiceException;
import jm.task.core.jdbc.dao.exceptions.UtilException;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {

    private static Connection connection = null;
    private static final String HOST_NAME = "localhost";
    private static final String DB_NAME = "core_task_db";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    private static final String CONNECTION_URL = "jdbc:mysql://" + HOST_NAME + ":3306/" + DB_NAME;

    public static Connection getConnection() throws DBServiceException {
        if (Util.connection == null) {
            try {
                Util.connection = DriverManager.getConnection(CONNECTION_URL, USER_NAME,
                        PASSWORD);
            } catch (Exception exception) {
                throw new DBServiceException(UtilException.NO_CONNECTION_MSG, exception);
            }
        }
        return Util.connection;
    }
}
