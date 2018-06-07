package com.codeup.adlister.dao;

import com.codeup.adlister.Config;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Config x = new Config("xxx", "xxx", "xxx");


    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(x);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if(usersDao == null){
            usersDao = new MySQLUsersDao(x);
        }
        return usersDao;
    }
}
