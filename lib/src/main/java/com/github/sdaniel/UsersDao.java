package com.github.sdaniel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDao implements Dao<Users> {
    private Connection con;

    public UsersDao(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    @Override
    public List<Users> getAll() {
        List<Users> users = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM employees");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Users temp = new Users(rs.getInt("eid"), rs.getInt("mid"), rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("email"), rs.getString("pass"),
                        rs.getString("position"));
                users.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void insert(Users user) {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Users (eid, mid, first_name, last_name, email, pass, position) values (?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, user.getEid());
            ps.setInt(2, user.getMid());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPassword());
            ps.setString(7, user.getPosition());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
