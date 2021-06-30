/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author toesl
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String actionValue = request.getParameter("action");

        //checks if the action parameter key has a value of logout
        if (actionValue != null && actionValue.equals("logout")) {
            session.invalidate(); 
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        //otherwise checks if username is null
        else if (session.getAttribute("username") == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        //otherwise load the shopping list
        else {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
 
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String usernameValue = request.getParameter("usernameInput");
        //creates an empty arraylist
        ArrayList<String> itemList = new ArrayList<String>();

        //checks if the itemList session attribute already exists
        if (session.getAttribute("itemList") != null) {
            //sets the itemList variable to the current arraylist
            itemList = (ArrayList<String>) session.getAttribute("itemList");
        } 
        //Otherwise creates the itemList session attribute
        else {
            session.setAttribute("itemList", itemList);
        }
        
        //checks if the username session attribute exists
        if (usernameValue != null) {
            //Sets the username session attribute to the new value
            session.setAttribute("username", usernameValue);
        }
        String actionValue = request.getParameter("action");

        //checks if the username session attribute doesn't exist
        if (session.getAttribute("username") == null) {
            //redirects user to the register page
            response.sendRedirect("ShoppingList");
        }
        //Checks if the action parameter key equals add
        if (actionValue.equals("add")) {
            String item = request.getParameter("itemInput");
            //Checks if itemInput isn't empty and adds it
            if (item != null || item != "") {
                itemList.add(item);
                session.setAttribute("itemList", itemList);
            }
        }
        //Checks if the action parameter key equals delete
        else if (actionValue.equals("delete")) {
            //removes the item and re-sets the attribute for the list
            itemList.remove(request.getParameter("itemRadio"));
            session.setAttribute("itemList", itemList);
        }
        
        //re forwards the page after all the logic is processed.
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        
        
    }

}
