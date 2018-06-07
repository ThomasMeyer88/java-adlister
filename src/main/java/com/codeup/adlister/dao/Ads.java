package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    List<Ad> title(String title);

    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    void deleteQuery(String adId);

    Ad findById(int id);

    List<Ad> listByUser(int id);



}