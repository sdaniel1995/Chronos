package com.github.sdaniel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao implements Dao<Employee> {
    private Connection con;

    public EmployeeDao(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM employees");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee temp = new Employee(rs.getInt("eid"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("email"));
                employees.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void insert(Employee employee) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO employees (first_name, last_name, email) values (?, ?, ?)");
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
