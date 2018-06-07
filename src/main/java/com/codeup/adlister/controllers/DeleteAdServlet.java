package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

@WebServlet(name = "controllers.DeleteAdServlet", urlPatterns = "/delete")
public class DeleteAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (request.getSession().getAttribute("user") == null) {
                response.sendRedirect("/login");
                return;
            }
        } catch (NullPointerException e){
            response.sendRedirect("/ads");
        }
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.getSession().getAttribute("user") == null){
            response.sendRedirect("/login");
        } else {
            String username = (String) request.getSession().getAttribute("username");
            User user = DaoFactory.getUsersDao().findByUsername(username);
            String adid = request.getParameter("adId");
            int adId = Integer.parseInt(adid);
            Ad adCheck = DaoFactory.getAdsDao().findById(adId);

            if (adCheck.getUserId() == user.getId()) {

                DaoFactory.getAdsDao().deleteQuery(adid);
            }

            response.sendRedirect("/ads");
        }
    }
}
