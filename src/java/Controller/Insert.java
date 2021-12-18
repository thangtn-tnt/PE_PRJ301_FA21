/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.StaffDAO;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Trương Nhựt Thăng
 */
@WebServlet(name = "Insert", urlPatterns = {"/Insert"})
public class Insert extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("IDStaff");
        String name = request.getParameter("Fullname");
        String phone = request.getParameter("Phone");
        String date = request.getParameter("Date");
        
        Connection conn = DB.DBConnect.getConnection();
        if (StaffDAO.insert(conn, id, name, phone, date)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("name", name + " has been successfully added!!!");
            request.getRequestDispatcher("Show").forward(request, response);
        } else {
            request.setAttribute("msg", "Wrong format from Database SQL Server");
            request.getRequestDispatcher("insert.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
