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
import model.Weapon;
import utils.Validate;

/**
 *
 * @author LuanNMSE62431
 */
public class ProcessAddNewWeapon extends HttpServlet {

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
        String weapon_id = request.getParameter("weapon_id");
        String weapon_name = request.getParameter("weapon_name");
        String description = request.getParameter("description");
        String type = request.getParameter("type");
        String robotId = request.getParameter("selection");        
        RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/add_weapon.jsp");
        if (!Validate.checkString(weapon_id)) { 
            request.setAttribute("error", "weapon_id is invalid");
            dis.forward(request, response);
        } else if (!Validate.checkString(weapon_name)) {
            request.setAttribute("error", "weapon_name is invalid");
            dis.forward(request, response);
        } else if (!Validate.checkString(description)) {
            request.setAttribute("error", "description is invalid");
            dis.forward(request, response);
        } else if (type == null) {
            request.setAttribute("error", "type is invalid");
            dis.forward(request, response);
        } 
        else {
            Weapon weapon = new Weapon(weapon_id, weapon_name, description, type, robotId);
            if (UserDAO.addNewWeapon(weapon)){
                response.sendRedirect("ProcessToWeaponManager");
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
