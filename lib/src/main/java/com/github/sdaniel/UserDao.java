package com.github.sdaniel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Connection con;

    public UserDao(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User temp = new User(0, rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"),
                        rs.getString("pass"), rs.getString("position"));
                users.add(temp);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void insert(User user) {
        try {
            String sql = "INSERT INTO Users (first_name, last_name, user_name, email, pass, position) values (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUserName());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getPosition());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User validateLogin(String username, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND pass = ?";
        User temp = new User();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                temp.setId(rs.getInt("id"));
                temp.setFirstName(rs.getString("first_name"));
                temp.setLastName(rs.getString("last_name"));
                temp.setEmail(rs.getString("email"));
                temp.setPassword(rs.getString("pass"));
                temp.setPosition(rs.getString("position"));
                temp.setUserName(rs.getString("user_name"));
                temp.setPicture(rs.getString("picture"));
                return temp;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User();
    }

    public void updateProfile(User user) {
        String sql = "UPDATE users SET first_name = ?, last_name = ?, user_name = ?, email = ?, pass = ?, position = ?, picture = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUserName());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getPosition());
            ps.setString(7, user.getPicture());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
