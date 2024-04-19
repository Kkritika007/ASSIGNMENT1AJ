package com.example.assignment1aj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {
    public static String userName = "Kritika200553441";
    public static String pass = "QDqjVR-efn";
    public static String url = "jdbc:mysql://172.31.22.43:3306/Kritika200553441";

    public DBUtility() {
    }

    public static List<Restaurant> getDataFromDB() {
        List<Restaurant> restaurants = new ArrayList<>();
        String sql = "SELECT * FROM restaurant_orders;";

        try {
            Connection conn = DriverManager.getConnection(url, userName, pass);

            try {
                Statement stmt = conn.createStatement();

                try {
                    ResultSet rs = stmt.executeQuery(sql);

                    try {
                        while (rs.next()) {
                            int orderid = rs.getInt("orderid");
                            String itemname = rs.getString("itemname");
                            String Customername = rs.getString("Customername");
                            String orderday = rs.getString("orderday");
                            double price = rs.getDouble("price");
                            Restaurant restaurant = new Restaurant(orderid, itemname, Customername, orderday , price);
                            restaurants.add(restaurant);
                        }
                    } catch (Throwable var16) {
                        if (rs != null) {
                            try {
                                rs.close();
                            } catch (Throwable var15) {
                                var16.addSuppressed(var15);
                            }
                        }

                        throw var16;
                    }

                    if (rs != null) {
                        rs.close();
                    }
                } catch (Throwable var17) {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (Throwable var14) {
                            var17.addSuppressed(var14);
                        }
                    }

                    throw var17;
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable var18) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var13) {
                        var18.addSuppressed(var13);
                    }
                }

                throw var18;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var19) {
            var19.printStackTrace();
        }

        return restaurants;
    }
}
