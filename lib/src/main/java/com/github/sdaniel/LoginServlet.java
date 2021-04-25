package com.github.sdaniel;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public boolean someLibraryMethod() {
        return true;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataBase dBase = new DataBase();
        HttpSession session = req.getSession();
        final Logger logger = LogManager.getLogger(LoginServlet.class);

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            UserDao uDao = new UserDao(dBase.connect());
            User user = uDao.validateLogin(username, password);
            
            if (user.getEmail().equals(username) && user.getPassword().equals(password) && user.getPosition().equals("Employee")) {
                logger.info("Login was successful!");
                session.setAttribute("uname", username);
                session.setAttribute("upass", password);
                resp.sendRedirect("/chronos.com/html/employee.html");
            } else if (user.getEmail().equals(username) && user.getPassword().equals(password)
                    && user.getPosition().equals("Manager")) {
                logger.info("Login was successful!");
                session.setAttribute("uname", username);
                session.setAttribute("upass", password);
                resp.sendRedirect("/chronos.com/html/manager.html");
            } else {
                logger.info("Login failed, Invalid username or password!");
                resp.getWriter().println("<script type=\"text/javascript\">");
                resp.getWriter().println("alert('Username or password incorrect');");
                resp.getWriter().println("location='/chronos.com/html/';");
                resp.getWriter().println("</script>");
            }
        } catch (

        SQLException e) {
            e.printStackTrace();
        }
    }
}
