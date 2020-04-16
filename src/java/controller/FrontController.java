/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LuanNMSE62431
 */
public class FrontController extends HttpServlet {

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
        RequestDispatcher dis = null;
        String action = request.getParameter("action");
        if (action.equals("Login")) {
            dis = request.getRequestDispatcher("ProcessLogin");
            dis.forward(request, response);
        } else if (action.equals("Logout")) {
            dis = request.getRequestDispatcher("ProcessLogout");
            dis.forward(request, response);
        }else if (action.equals("ViewProfile")) {
            dis = request.getRequestDispatcher("ProcessViewProfile");
            dis.forward(request, response);
        }else if (action.equals("ToEditProfile")) {
            dis = request.getRequestDispatcher("ProcessToEditProfile");
            dis.forward(request, response);
        }else if (action.equals("EditProfile")) {
            dis = request.getRequestDispatcher("ProcessSaveProfile");
            dis.forward(request, response);
        }else if (action.equals("ToEditPassword")) {
            dis = request.getRequestDispatcher("ProcessToEditPassword");
            dis.forward(request, response);
        }else if (action.equals("EditPassword")) {
            dis = request.getRequestDispatcher("ProcessSavePassword");
            dis.forward(request, response);
        }else if (action.equals("ViewMyMission")) {
            dis = request.getRequestDispatcher("ProcessViewMyMission");
            dis.forward(request, response);
        }else if (action.equals("ToViewDetailMission")) {
            dis = request.getRequestDispatcher("ProcessToViewMissionDetail");
            dis.forward(request, response);
        }else if (action.equals("ToChangeWeapon")) {
            dis = request.getRequestDispatcher("ProcessToChangeWeapon");
            dis.forward(request, response);
        }else if (action.equals("ChangeWeapon")) {
            dis = request.getRequestDispatcher("ProcessChangeWeapon");
            dis.forward(request, response);
        }else if (action.equals("ToIndex")) {
            dis = request.getRequestDispatcher("ProcessToIndex");
            dis.forward(request, response);
        }else if (action.equals("ToDashboard")) {
            dis = request.getRequestDispatcher("ProcessToDashboard");
            dis.forward(request, response);
        }else if (action.equals("ToPillotManager")) {
            dis = request.getRequestDispatcher("ProcessToPillotManager");
            dis.forward(request, response);
        }else if (action.equals("ToAdminViewUserDetail")) {
            dis = request.getRequestDispatcher("ProcessToAdminViewUserDetail");
            dis.forward(request, response);
        }else if (action.equals("ResetPassword")) {
            dis = request.getRequestDispatcher("ProcessResetPassword");
            dis.forward(request, response);
        }else if (action.equals("BlockPillot")) {
            dis = request.getRequestDispatcher("ProcessBlockPillot");
            dis.forward(request, response);
        }else if (action.equals("UnblockPillot")) {
            dis = request.getRequestDispatcher("ProcessUnblockPillot");
            dis.forward(request, response);
        }else if (action.equals("ToAddPillot")) {
            dis = request.getRequestDispatcher("ProcessToAddPillot");
            dis.forward(request, response);
        }else if (action.equals("ChooseRobotForPillot")) {
            dis = request.getRequestDispatcher("ProcessChooseRobotForPillot");
            dis.forward(request, response);
        }else if (action.equals("AddNewPillot")) {
            dis = request.getRequestDispatcher("ProcessAddNewPillot");
            dis.forward(request, response);
        }else if (action.equals("SearchName")) {
            dis = request.getRequestDispatcher("ProcessSearchName");
            dis.forward(request, response);
        }else if (action.equals("ToRobotManager")) {
            dis = request.getRequestDispatcher("ProcessToRobotManager");
            dis.forward(request, response);
        }else if (action.equals("ToAdminViewRobotDetail")) {
            dis = request.getRequestDispatcher("ProcessToAdminViewRobotDetail");
            dis.forward(request, response);
        }else if (action.equals("ToEditRobot")) {
            dis = request.getRequestDispatcher("ProcessToEditRobot");
            dis.forward(request, response);
        }else if (action.equals("ToAddRobot")) {
            dis = request.getRequestDispatcher("ProcessToAddRobot");
            dis.forward(request, response);
        }else if (action.equals("AddNewRobot")) {
            dis = request.getRequestDispatcher("ProcessAddNewRobot");
            dis.forward(request, response);
        }else if (action.equals("ToWeaponManager")) {
            dis = request.getRequestDispatcher("ProcessToWeaponManager");
            dis.forward(request, response);
        }else if (action.equals("DeleteWeapon")) {
            dis = request.getRequestDispatcher("ProcessDeleteWeapon");
            dis.forward(request, response);
        }else if (action.equals("ToAddWeapon")) {
            dis = request.getRequestDispatcher("ProcessToAddWeapon");
            dis.forward(request, response);
        }else if (action.equals("AddNewWeapon")) {
            dis = request.getRequestDispatcher("ProcessAddNewWeapon");
            dis.forward(request, response);
        }else if (action.equals("ToMissionManager")) {
            dis = request.getRequestDispatcher("ProcessToMissionManager");
            dis.forward(request, response);
        }else if (action.equals("ToAdminViewMissionDetail")) {
            dis = request.getRequestDispatcher("ProcessToAdminViewMissionDetail");
            dis.forward(request, response);
        }else if (action.equals("ToAdminEditMissionDetail")) {
            dis = request.getRequestDispatcher("ProcessToAdminEditMissionDetail");
            dis.forward(request, response);
        }else if (action.equals("AdminEditMissionDetail")) {
            dis = request.getRequestDispatcher("ProcessAdminEditMissionDetail");
            dis.forward(request, response);
        }else if (action.equals("ToAddMission")) {
            dis = request.getRequestDispatcher("ProcessToAddMission");
            dis.forward(request, response);
        }else if (action.equals("AddNewMission")) {
            dis = request.getRequestDispatcher("ProcessAddNewMission");
            dis.forward(request, response);
        }
        
        
        else {
            response.sendRedirect("./");
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
