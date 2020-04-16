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
import model.Profile;
import utils.Validate;

/**
 *
 * @author LuanNMSE62431
 */
public class ProcessAddNewPillot extends HttpServlet {

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
        String userName = request.getParameter("username");
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String password = "123456";
        String birthday = request.getParameter("birthday");
        String sex = request.getParameter("gender");
        String robotId = request.getParameter("selection");
        if (robotId == null) {
            robotId ="";
        }
        RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/add_pillot.jsp");
        if (!Validate.checkString(fullName)) { 
            request.setAttribute("error", "Name is invalid");
            dis.forward(request, response);
        } else if (!Validate.checkMobile(phone)) {
            request.setAttribute("error", "phone is invalid");
            dis.forward(request, response);
        } else if (birthday == null) {
            request.setAttribute("error", "Birthday is invalid");
            dis.forward(request, response);
        } else if (birthday == "") {
            request.setAttribute("error", "Birthday is invalid");
            dis.forward(request, response);
        }else if (sex == null) {
            request.setAttribute("error", "sex is invalid");
            dis.forward(request, response);
        } 
        else {
            Profile profile = new Profile(userName, fullName, phone, sex, birthday, password, "user", "images/avt_2.jpg", robotId, true, true);
            if (UserDAO.addNewPillot(profile)){
                response.sendRedirect("ProcessToPillotManager");
            } else {
                request.setAttribute("error", "Sorry, have some problem. Bye!");
                dis.forward(request, response);
            }
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
