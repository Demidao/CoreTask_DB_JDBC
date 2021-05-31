package jm.task.core.jdbc.dao.exceptions;

public class UtilException {
    public static final String NO_CONNECTION_MSG = "Connection with DB was not installed:\n";
    public static final String BAD_CLEAN_USERS_TABLE_MSG = "Bad try to clean DB. Users were NOT removed from DB:\n";
    public static final String BAD_CREATE_USERS_MSG = "Table was NOT created:\n";
    public static final String BAD_DROP_USERS_MSG = "Table was NOT dropped:\n";
    public static final String BAD_GET_ALL_USERS_MSG = "Bad try to get all users from DB:\n";
    public static final String BAD_REMOVE_USER_MSG = "User was NOT removed from DB:\n";
    public static final String BAD_SAVE_USER_MSG = "User was NOT saved in DB:\n";
}
