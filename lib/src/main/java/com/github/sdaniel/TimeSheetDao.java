package com.github.sdaniel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeSheetDao {
    private Connection con;

    public TimeSheetDao(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public List<TimeSheet> getAll() {
        List<TimeSheet> tSheets = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TimeSheet temp = new TimeSheet(rs.getInt("time_id"), rs.getInt("id"), rs.getDouble("total_hrs"), rs.getString("status"));
                temp.setSubmitDate(rs.getDate("submit_date"));
                tSheets.add(temp);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tSheets;
    }

    public void insert(TimeSheet tSheet) {
        try {
            String sql = "INSERT INTO timesheets (id, submit_date, total_hrs, status) values (?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, tSheet.getEid());
            ps.setDate(2, tSheet.getSubmitDate());
            ps.setDouble(3, tSheet.getTotalHours());
            ps.setString(4, tSheet.getStatus());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
