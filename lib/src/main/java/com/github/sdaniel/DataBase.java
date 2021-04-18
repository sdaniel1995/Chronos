package com.github.sdaniel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private String url;
    private String user;
    private String password;

    public DataBase() {
        url = "jdbc:postgresql://localhost:5432/chronos";
        user = "chronos";
        password = "password";
    }

    public void startServer() {
        String cmd = "docker start dazzling_buck";
        Runtime run = Runtime.getRuntime();
        Process pr;
        try {
            pr = run.exec(cmd);
            pr.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() {
        String cmd = "docker stop dazzling_buck";
        Runtime run = Runtime.getRuntime();
        Process pr;
        try {
            pr = run.exec(cmd);
            pr.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Connection connect() throws SQLException {
        Connection con = DriverManager.getConnection(this.url, this.user, this.password);
        return con;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
