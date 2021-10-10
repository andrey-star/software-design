package ru.akirakozov.sd.refactoring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {
    private static final String DB_URL = "jdbc:sqlite:test.db";

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
}
