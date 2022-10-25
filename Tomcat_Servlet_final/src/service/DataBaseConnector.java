package service;
// databaseconnector 连接数据库 由于数据库暂未开通，所以不会返回数据的
// DataBaseConnector d=new DataBaseConnector();
// ResultSet r=d.quest("一段MYSQL语句");
// 增删改返回null 查返回ResultSet
import java.sql.*;

public class DataBaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/video";
    private static final String USER = "root";
    private static final String PASSWORD = "MYSQL695";

    public ResultSet quest(String sqlQuest) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;
        if (conn == null) {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        ResultSet rs = null;
        // select
        if ((sqlQuest.charAt(0) == 's') || (sqlQuest.charAt(0) == 'S')) {
            try {
                Statement stmt = conn.createStatement();
                rs = stmt.executeQuery(sqlQuest);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {  // insert delete update 不能用stmt.executeQuery(sqlQuest)来实现
            try {
                PreparedStatement ppst = conn.prepareStatement(sqlQuest);
                int n = ppst.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
}
