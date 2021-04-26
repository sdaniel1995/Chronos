package com.github.sdaniel;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class UserDaoTest {
    
    @Test
    void getAllTest() throws SQLException {
        DataBase dBase = new DataBase();
        UserDao uDao = new UserDao(dBase.connect());
        List<User> test = new ArrayList<>();
        test = uDao.getAll();
        assertNotEquals(null, test);
    }

    @Test
    void validateLoginTest() throws SQLException {
        DataBase dBase = new DataBase();
        UserDao uDao = new UserDao(dBase.connect());
        User test = new User();
        test = uDao.validateLogin("paula.daniel@revature.net", "pass1");
        assertNotEquals(null, test);
    }
}
