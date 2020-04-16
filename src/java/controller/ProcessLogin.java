/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Profile;

/**
 *
 * @author LuanNMSE62431
 */
public class ProcessLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("user_name");
        String password = request.getParameter("user_password");
        Profile profile = UserDAO.checkLogin(userName, password);
        HttpSession session = request.getSession();
        if (profile != null) { //success
            session.setAttribute("user", profile);
            if (profile.isStatus()) {
                if (profile.getRole().equalsIgnoreCase("admin")) {
                    session.setAttribute("mess", "");
                    RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/dashboard.jsp");
                    dis.forward(request, response);
                } else {
                    session.setAttribute("mess", "");
                    response.sendRedirect("ProcessToIndex");
                }
            } else {
                session.setAttribute("mess", "Account was blocked by Admin! Sorry!");
                response.sendRedirect("page-login.jsp");
            }
        } else {
            session.setAttribute("mess", "Wrong username or password.");
            response.sendRedirect("page-login.jsp");
            //response.sendRedirect("page-error.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
