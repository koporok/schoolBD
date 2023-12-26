package com.example.school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class GroupDatabase {

    // Подключение к базе данных
    private static Connection connect() {
        String url = "jdbc:h2:~/test"; // URL для подключения к базе данных (можно выбрать другую базу данных)
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // Создание таблицы для хранения данных о группах
    public static void createGroupTable() {
        String sql = "CREATE TABLE IF NOT EXISTS groups (\n"
                + " id INTEGER AUTO_INCREMENT PRIMARY KEY,\n"
                + " group_number INTEGER NOT NULL\n"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Вставка данных о группе в таблицу
    public static void insertGroup(int groupNumber, String nameGroup) {
        String sql = "INSERT INTO groups(id, group_number) VALUES( "+groupNumber+ " , "+ groupNumber + ")";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Получение данных о всех группах
    public static String selectAllGroups() {
        String sql = "SELECT id, group_number FROM groups";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getInt("group_number"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sql;
    }

    // Удаление данных о группе из таблицы
    public static void deleteGroup(int groupId) {
        String sql = "DELETE FROM groups WHERE id = " + groupId ;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
