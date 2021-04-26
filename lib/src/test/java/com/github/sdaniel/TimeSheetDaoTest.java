package com.github.sdaniel;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TimeSheetDaoTest {

    @Test
    void getAllTest() throws SQLException {
        DataBase dBase = new DataBase();
        TimeSheetDao tDao = new TimeSheetDao(dBase.connect());
        List<TimeSheet> test1 = new ArrayList<>();
        List<TimeSheet> test2 = new ArrayList<>();
        test1 = tDao.gettAll();
        test2 = tDao.getAll(2);
        assertNotEquals(null, test1);
        assertNotEquals(null, test2);
    }
}
