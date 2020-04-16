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
import model.Robot;
import utils.Validate;

/**
 *
 * @author LuanNMSE62431
 */
public class ProcessAddNewRobot extends HttpServlet {

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
        String robotId = request.getParameter("robotId");
        String robotName = request.getParameter("robotName");
        String description = request.getParameter("description");
        Boolean status = true;
        
        RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/add_robot.jsp");
        if (!Validate.checkString(robotId)) { 
            request.setAttribute("error", "ID is invalid");
            dis.forward(request, response);
        } else if (!Validate.checkString(robotName)) {
            request.setAttribute("error", "Name is invalid");
            dis.forward(request, response);
        } else if (!Validate.checkString(description)) {
            request.setAttribute("error", "description is invalid");
            dis.forward(request, response);
        } 
        else {
            Robot robot = new Robot(robotId, robotName, description, status);
            if (UserDAO.addNewRobot(robot)){
                response.sendRedirect("ProcessToRobotManager");
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
