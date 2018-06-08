package com.codeup.adlister.controllers;

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

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        List<Ad> ads = DaoFactory.getAdsDao().all();

        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("viewUser");
        User user = DaoFactory.getUsersDao().findByUserId(userId);
        int id = user.getId();
        request.setAttribute("viewUser", user);
        request.setAttribute("viewUserId", id);
        List<Ad> userAds = DaoFactory.getAdsDao().listByUser(id);
        request.setAttribute("viewUserAds", userAds);
        request.setAttribute("viewUserName", user.getUsername());
        request.getRequestDispatcher("/WEB-INF/viewProfile.jsp").forward(request, response);
    }
}
