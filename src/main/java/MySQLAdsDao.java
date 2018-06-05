import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Driver;

public class MySQLAdsDao implements Ads{

    private Connection connection;

    public MySQLAdsDao(Config config) throws SQLException{
        DriverManager.registerDriver(new Driver());
        try {
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword());
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Ad> all() throws SQLException {
        String selectAll = "SELECT * FROM ads";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(selectAll);
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(new Ad(
                    rs.getInt("userid"),
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description")));
        }

        return ads;
    }

    @Override
    public Long insert(Ad ad) throws SQLException {
        String insert = "INSERT INTO adlister_db.ads(userid, title, description) " + "VALUES (" + ad.getUserId() +","+ ad.getTitle()
                + "," + ad.getDescription() +")";
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            System.out.println("Inserted a new record! New id: " + rs.getLong(1));
        }
        return null;
    }
}
