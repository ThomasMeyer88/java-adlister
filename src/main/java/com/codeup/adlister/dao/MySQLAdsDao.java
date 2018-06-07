package com.codeup.adlister.dao;


import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.core.util.StringUtils;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.codeup.adlister.Config;



public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        try {
            String sql = "SELECT * FROM ads";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }
    @Override
    public List<Ad> title(String title) {
        try {
            String sql = "SELECT * FROM ads WHERE title LIKE ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            title = "%" + "" + title + "" + "%";
            stmt.setString(1, title);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public List<Ad> listByUser (int id) {
        try{
            String sql = "SELECT * FROM ads WHERE userid = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            String userId = Integer.toString(id);
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ads by user id", e);
        }
    }
    @Override
    public Long insert(Ad ad) {
        try {
            String sql = "INSERT INTO ads(userid, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.executeUpdate(createInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private String createInsertQuery(Ad ad) {
        return "INSERT INTO ads(userid, title, description) VALUES "
            + "(" + ad.getUserId() + ", "
            + "'" + ad.getTitle() +"', "
            + "'" + ad.getDescription() + "')";
    }

    @Override
    public void deleteQuery(String adId){
        try {
                String sql = "DELETE FROM ads WHERE id = ? Limit 1";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, adId);


                stmt.execute();
            } catch (SQLException e) {
                throw new RuntimeException("Error deleting ad", e);
            }
    }

    @Override
    public Ad findById(int id) {
        String query = "SELECT * FROM ads WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String adId = Integer.toString(id);
            stmt.setString(1, adId);
            return extractAdId(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ad by id", e);
        }
    }

    private Ad extractAdId(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new Ad(
                rs.getLong("id"),
                rs.getLong("userid"),
                rs.getString("title"),
                rs.getString("description")
        );
    }


    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("userid"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
