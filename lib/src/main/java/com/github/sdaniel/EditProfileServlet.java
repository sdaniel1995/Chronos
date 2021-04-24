package com.github.sdaniel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet("/editProfile")
public class EditProfileServlet extends HttpServlet {

    public void fileUpload(Part part) throws IOException {
        //
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataBase dBase = new DataBase();
        User user = new User();
        HttpSession session = req.getSession();
        final Logger logger = LogManager.getLogger(LoginServlet.class);

        String imagePath = "../images/" + req.getParameter("image-upload");
        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            if (session.getAttribute("uname") != null) {
                UserDao uDao = new UserDao(dBase.connect());
                String uname = (String) session.getAttribute("uname");
                String pass = (String) session.getAttribute("upass");

                user = uDao.validateLogin(uname, pass);

                if (req.getPart("image-upload").getSubmittedFileName().equals("")) {
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setUserName(username);
                    user.setEmail(email);
                    user.setPassword(password);
                } else {
                    fileUpload(req.getPart("image-upload"));
                    user.setPicture(imagePath);
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setUserName(username);
                    user.setEmail(email);
                    user.setPassword(password);
                }
                uDao.updateProfile(user);
                resp.sendRedirect("/chronos.com/html/employee.html");
            } else {
                resp.sendRedirect("/chronos.com/html/");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
