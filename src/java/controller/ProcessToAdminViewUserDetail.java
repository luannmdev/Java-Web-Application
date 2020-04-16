/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Profile;
import model.Robot;

/**
 *
 * @author LuanNMSE62431
 */
public class ProcessToAdminViewUserDetail extends HttpServlet {

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
        if (session.getAttribute("user") != null) {
            String username = request.getParameter("username");
            Profile profile = UserDAO.getProfileByAdmin(username);
            session.setAttribute("profilePillot", profile);
            session.setAttribute("robot2", null);
            session.setAttribute("weaponlist2", null);
            List<Robot> freeRobotList = UserDAO.getFreeRobotList();
            session.setAttribute("freeRobotList", freeRobotList);
            if (profile.getRobot_id() != null) {
                if (!"".equals(profile.getRobot_id())) {
                    Robot robot = UserDAO.getRobotProfile(profile.getRobot_id());
                    robot.setListWeapon(UserDAO.getWeaponList(robot.getRobot_id())); //co the null
                    session.setAttribute("robot2", robot);
                    session.setAttribute("weaponlist2", robot.getListWeapon());
                    session.setAttribute("profilePillot", profile);
                }
            }
            RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/admin_view_pilot.jsp");
            dis.forward(request, response);
        } else {
            response.sendRedirect("page-login.jsp");
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
