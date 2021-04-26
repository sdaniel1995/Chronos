package com.github.sdaniel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)

@WebServlet("/editProfile")
public class EditProfileServlet extends HttpServlet {

    public void fileUpload(Part part) throws IOException {
        String fileName = part.getSubmittedFileName();

        File fileSaveDir = new File("/Volumes/Software/Developer/Java-Programs/Revature/Projects/Chronos/lib/src/main/webapp/images");

        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        File file = new File(fileSaveDir, fileName);
        
        try(InputStream input = part.getInputStream())
        {
            Files.copy(input, file.toPath());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataBase dBase = new DataBase();
        User user = new User();
        HttpSession session = req.getSession(false);
        final Logger logger = LogManager.getLogger(LoginServlet.class);

        String imagePath = "../images/" + req.getPart("image-upload").getSubmittedFileName();
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
                logger.info("{} {}'s profile was updated!", firstName, lastName);
                resp.sendRedirect("/chronos.com/html/employee.html");
            } else {
                resp.sendRedirect("/chronos.com/html/");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
