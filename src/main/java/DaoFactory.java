import java.sql.SQLException;

public class DaoFactory {
    private static Ads adsDao;

    public static Ads getAdsDao() throws SQLException {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(new Config(
                    "jdbc:mysql://localhost:3306/adlister_db?serverTimezone=UTC&useSSL=false",
                    "root",
                    "codeup"));
        }
        return adsDao;
    }
}
