package jm.task.core.jdbc.dao.exceptions;

public class DBServiceException extends Exception{

    public DBServiceException(Exception e) {
        System.out.println(e.getMessage());
    }

    public DBServiceException(String msg, Exception e) {
        System.out.println(msg + e.getMessage());
    }

}
