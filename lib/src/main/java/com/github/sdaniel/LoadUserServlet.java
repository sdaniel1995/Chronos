package com.github.sdaniel;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/user")
public class LoadUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
        ObjectMapper mapper = new ObjectMapper();
        HttpSession session = req.getSession(false);
        DataBase dBase = new DataBase();

        try {
            if (session.getAttribute("uname") != null) {
                UserDao uDao = new UserDao(dBase.connect());
                String username = (String) session.getAttribute("uname");
                String password = (String) session.getAttribute("upass");

                user = uDao.validateLogin(username, password);
                String jsonString = mapper.writeValueAsString(user);
                resp.setContentType("application/json");
                resp.getWriter().println(jsonString);
            } else {
                resp.sendRedirect("/chronos.com/html/");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
