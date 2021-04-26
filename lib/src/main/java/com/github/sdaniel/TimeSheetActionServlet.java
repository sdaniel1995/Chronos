package com.github.sdaniel;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/action")
public class TimeSheetActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataBase dBase = new DataBase();
        String accept = req.getParameter("accept");
        String decline = req.getParameter("decline");
        int eid = Integer.parseInt(req.getParameter("eid"));

        System.out.println(accept + "\n" + decline + "\n" + eid);

        try {
            TimeSheetDao tDao = new TimeSheetDao(dBase.connect());
            if(accept != null) {
                tDao.update(eid, "Accepted");
            }
            
            if(decline != null) {
                tDao.update(eid, "Declined");
            }
            resp.sendRedirect("/chronos.com/html/manager.html");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
