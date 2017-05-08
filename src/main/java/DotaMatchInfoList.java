import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;

/**
 * Created by kk on 2017/4/25.
 */
public class DotaMatchInfoList {

    private static final String API_KEY = "7F96F168DE0894F95BCD94C2BE3D5D87";
    private static final String RESULT = "result";
    private static final String HEROES = "heroes";
    private static final String LEAGUES = "leagues";

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String CONN_URL = "jdbc:mysql://localhost:3306/dota_info";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private JSONArray jsonArray;

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(CONN_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return conn;
    }

    public void closeConnection() {

    }

    public String loadJson(String urlStr) {
        StringBuilder json = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            URLConnection uc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return json.toString();
    }

    public void insertAllHeroes() {
    }

    public static void main(String args[]) {
        //英雄列表url：http://api.steampowered.com/IEconDOTA2_570/GetHeroes/v1?key=7F96F168DE0894F95BCD94C2BE3D5D87&language=zh_cn
        //联赛比赛列表url：http://api.steampowered.com/IDOTA2Match_570/GetLeagueListing/v1?key=7F96F168DE0894F95BCD94C2BE3D5D87&language=zh_cn
        DotaMatchInfoList dota = new DotaMatchInfoList("http://api.steampowered.com/IDOTA2Match_570/GetLeagueListing/v1?key=7F96F168DE0894F95BCD94C2BE3D5D87&language=zh_cn");
        dota.insert();
    }

    public DotaMatchInfoList(String url) {
        String str = this.loadJson(url);
        JSONObject object = JSONObject.fromObject(str);
        JSONObject obInside = (JSONObject) object.get(RESULT);
        //json部分get的string
        jsonArray = (JSONArray) obInside.get(LEAGUES);
    }

    private void insert() {
        try {
            Connection conn = this.getConnection();
            //Statement st = conn.createStatement();
            PreparedStatement preparedStatement = null;
            LeagueListing listing = new LeagueListing();
            preparedStatement = conn.prepareStatement(listing.linkStr());
            for (int i = 0; i < jsonArray.size(); i++) {
                //Hero hero = new Hero(jsonArray.getJSONObject(i));
                //String insertStr = hero.linkStr();
                //st.addBatch(insertStr);
                LeagueListing leagueListing = new LeagueListing(jsonArray.getJSONObject(i));
                //preparedStatement = conn.prepareStatement(leagueListing.linkStr());
                for (int j = 0; j < leagueListing.fields(); j++) {
                    preparedStatement.setString(j + 1, leagueListing.get(j));
                }
                preparedStatement.addBatch();
                //String insertStr = leagueListing.linkStr();
                //st.addBatch(insertStr);
            }
            preparedStatement.executeBatch();
            //st.executeBatch();
            //st.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
