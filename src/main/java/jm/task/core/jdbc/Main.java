package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserService userService = new UserServiceImpl();

        //userService.getAllUsers();
        userService.dropUsersTable();
      //  userService.createUsersTable();
        // userService.saveUser("Sam","lo",(byte) 23);
       // userService.saveUser("Harry","Ki",(byte) 44);
//        userService.saveUser("Ann","Grant",(byte) 33);
//        userService.saveUser("Tony","F",(byte) 54);
//
//        userService.removeUserById(2);
//
//        userService.cleanUsersTable();
//        userService.dropUsersTable();
    }
}
