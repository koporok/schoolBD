package com.example.school;

import java.sql.*;

public class DatabaseHandler {
        Connection connection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver"); // Загрузка JDBC драйвера
        String url = "jdbc:postgresql://localhost:5432/schoolData"; // замените на реальные данные вашей базы данных
        String user = "postgres"; // имя пользователя
        String password = "aaprok"; // пароль
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public void signUser(Student student) {
        String insert = "INSERT INTO students (org_name, date_birth, org_year, telephone, org_group, login)"
                + "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, student.getStudentsFIO());
            prSt.setString(2, student.getStudentsDate());
            prSt.setInt(3, student.getStudentsYear());
            prSt.setString(4, student.getStudentsTelephone());
            prSt.setString(5, student.getStudentsGroupNumber());
            prSt.setString(6, student.getStudentsLogin());
            prSt.executeUpdate();
        }
        catch (SQLException e) {throw new RuntimeException(e);}
        catch (ClassNotFoundException e) {throw new RuntimeException(e);}
    }

    public ResultSet getUser(Student student) {
        ResultSet reSet = null;

        String select = "SELECT COUNT(*) AS login_count FROM students WHERE login  =?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, student.getStudentsLogin());
            reSet = prSt.executeQuery();
        }
        catch (SQLException e){throw new RuntimeException(e);}
        catch (ClassNotFoundException e) {throw new RuntimeException(e);}
        return reSet;
    }

}
