package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

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
        System.out.println(ads.get(0).getUserId());
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adid = request.getParameter("adInfo");
        int adId = Integer.parseInt(adid);
        Ad showAd = DaoFactory.getAdsDao().findById(adId);
        System.out.println("Ad id is " + showAd.getUserId());
        request.getSession().setAttribute("showAd", showAd);
        response.sendRedirect("/showinfo");
    }
}
