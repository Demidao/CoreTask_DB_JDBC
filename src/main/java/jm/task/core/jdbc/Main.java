package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            UserServiceImpl userService = new UserServiceImpl();

            userService.createUsersTable();

            userService.saveUser("Leonardo", "BlueOne", (byte) 19);
            System.out.println("User с именем – Leonardo добавлен в базу данных");
            userService.saveUser("Raphael", "RedOne", (byte) 18);
            System.out.println("User с именем – Raphael добавлен в базу данных");
            userService.saveUser("Donatello", "VioletOne", (byte) 17);
            System.out.println("User с именем – Donatello добавлен в базу данных");
            userService.saveUser("Michelangelo", "OrangeOne", (byte) 15);
            System.out.println("User с именем – Michelangelo добавлен в базу данных");

            List<User> allUsers = userService.getAllUsers();

            for (User user : allUsers) {
                System.out.println(user);
            }

            userService.cleanUsersTable();
            userService.dropUsersTable();

            Util.getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
