package services;

import repository.daos.UserDaoImpl;
import repository.models.User;

public class UserService {

    private UserDaoImpl uDao = new UserDaoImpl();

    public User login(String un, String pw) {
        System.out.println("****************");
        System.out.println("****************");
        System.out.println("USER SERVICE");
        System.out.println("Username: " + un);
        System.out.println("Password: " + pw);
        System.out.println("****************");
        System.out.println("****************");
        return uDao.login(un, pw);
    }
}
