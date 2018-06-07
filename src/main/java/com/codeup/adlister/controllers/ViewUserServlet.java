package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.ViewUserervlet", urlPatterns = "/viewuser")
public class ViewUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/viewProfile.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("viewUser");
        int id = Integer.parseInt(userId);
        User user = DaoFactory.getUsersDao().findByUserId(id);
        long userIdLong = user.getId();
        request.setAttribute("viewUser", user);
        request.setAttribute("viewUserId", userIdLong);
        List<Ad> userAds = DaoFactory.getAdsDao().listByUser(id);
        request.setAttribute("viewUserAds", userAds);
        request.setAttribute("viewUserName", user.getUsername());
        request.getRequestDispatcher("/WEB-INF/viewProfile.jsp").forward(request, response);


    }
}
