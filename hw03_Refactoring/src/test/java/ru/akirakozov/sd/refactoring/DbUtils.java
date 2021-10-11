package ru.akirakozov.sd.refactoring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

public class DbUtils {
    private static final String DB_URL = "jdbc:sqlite:test.db";
    public static final Map<String, Integer> SAMPLE_DATA = new LinkedHashMap<>();

    static {
        SAMPLE_DATA.put("min", 10);
        SAMPLE_DATA.put("middle", 25);
        SAMPLE_DATA.put("max", 50);
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void initProducts() throws SQLException {
        try (Connection c = getConnection()) {
            try (Statement s = c.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS PRODUCT" +
                        "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        " NAME           TEXT    NOT NULL, " +
                        " PRICE          INT     NOT NULL)";
                s.executeUpdate(sql);
            }
        }
    }

    public static void clearProducts() throws SQLException {
        try (Connection c = getConnection()) {
            try (Statement stmt = c.createStatement()) {
                String sql = "DELETE FROM PRODUCT";
                stmt.executeUpdate(sql);
            }
        }
    }

    public static void addSampleData() throws SQLException {
        for (Map.Entry<String, Integer> entry : DbUtils.SAMPLE_DATA.entrySet()) {
            addProduct(entry.getKey(), entry.getValue());
        }
    }

    public static void addProduct(String name, int value) throws SQLException {
        try (Connection c = getConnection()) {
            try (Statement s = c.createStatement()) {
                String sql = "INSERT INTO PRODUCT " +
                        "(NAME, PRICE) VALUES (\"" + name + "\"," + value + ")";
                s.executeUpdate(sql);
            }
        }
    }
}
