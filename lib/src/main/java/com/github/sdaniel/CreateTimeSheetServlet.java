package com.github.sdaniel;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/timesheet")
public class CreateTimeSheetServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataBase dBase = new DataBase();
        HttpSession session = req.getSession(false);
        User user = null;

        double totalHours = Double.parseDouble(req.getParameter("total-hrs"));
        
        try {
            TimeSheetDao tDao = new TimeSheetDao(dBase.connect());
            UserDao uDao = new UserDao(dBase.connect());
            String username = (String) session.getAttribute("uname");
            String password = (String) session.getAttribute("upass");
            user = uDao.validateLogin(username, password);
            tDao.insert(new TimeSheet(0, user.getId(), totalHours, "Pending"));
            resp.sendRedirect("/chronos.com/html/employee.html");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
