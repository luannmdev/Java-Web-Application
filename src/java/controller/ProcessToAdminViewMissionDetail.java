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
import model.Mission;
import model.MissionDetail;
import model.Profile;
import model.Robot;
import model.Weapon;

/**
 *
 * @author LuanNMSE62431
 */
public class ProcessToAdminViewMissionDetail extends HttpServlet {

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
            Profile profile = (Profile) session.getAttribute("user");
            int missionId = Integer.parseInt(request.getParameter("MissionId"));
            //get member with that missionID
            List<String> listOfMember = UserDAO.getListOfMemberMission(missionId);
            session.setAttribute("listOfMemberMission", listOfMember);
            //get info mission with that missionID
            Mission mission = UserDAO.getMissionDetailByMissionID(missionId);
            Robot robot = null;    
            Weapon thatTimeWeapon = null;
            MissionDetail missionDetail = new MissionDetail(mission, robot, thatTimeWeapon);
            session.setAttribute("missionDetail", missionDetail);
            RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/admin_view_mission.jsp");
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
