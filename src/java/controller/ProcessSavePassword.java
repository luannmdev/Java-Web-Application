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
import utils.Validate;

/**
 *
 * @author LuanNMSE62431
 */
public class ProcessSavePassword extends HttpServlet {

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
        HttpSession session = request.getSession();
        Profile oldProfile = (Profile)session.getAttribute("user");
        String username = oldProfile.getUserName();
        String password = request.getParameter("old_password");
        String newPassword = request.getParameter("new_password");
        String reNewPassword = request.getParameter("re_new_password");               
        RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/edit_password.jsp");
        if (!Validate.checkPassword(password)) {
            request.setAttribute("error", "Wrong Password");
            dis.forward(request, response);
        } else 
        if (!Validate.checkPassword(newPassword)) {
            request.setAttribute("error", "New Password is invalid");
            dis.forward(request, response);
        } else
        if (!Validate.checkPassword(reNewPassword)) {
            request.setAttribute("error", "re-new pass is invalid");
            dis.forward(request, response);
        } else 
        if (UserDAO.getProfile(username,password) == null) {
            request.setAttribute("error", "Wrong Password");
            dis.forward(request, response);
        } else 
        if (!newPassword.equalsIgnoreCase(reNewPassword)) {
            request.setAttribute("error", "New password and Renew Password are not equal!");
            dis.forward(request, response);
        }
        else {
            Profile profile = new Profile(username, "", "", "", "", newPassword, "", "", "", true, true);
            if (UserDAO.updatePassword(profile)){
                request.setAttribute("error", "Updated!");
            } else {
                request.setAttribute("error", "Sorry, have some problem.");
            }
            dis.forward(request, response);
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
