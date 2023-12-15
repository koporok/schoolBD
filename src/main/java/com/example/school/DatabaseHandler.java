package com.example.school;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public void addStudent(String login, int id) throws SQLException {
        String select = "UPDATE students SET login = ? WHERE students_id = ?"; // Определение запроса SQL
        try {
            Connection connection = getDbConnection(); // получение соединения с базой данных
            PreparedStatement prSt = connection.prepareStatement(select);
            prSt.setString(1, login);
            prSt.setInt(2, id);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Обработка исключений
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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

    public ObservableList<TableUsers> GetAllUsers() {
        String select = "SELECT * FROM students WHERE login = 'null';";
        ObservableList<TableUsers> list_users = FXCollections.observableArrayList();
        Connection connection = null;
        PreparedStatement prSt = null;

        try {
            connection = getDbConnection();
            prSt = connection.prepareStatement(select);
            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()) {
                list_users.add(new TableUsers(resultSet.getInt("students_id"), resultSet.getString("org_name"),
                        resultSet.getString("date_birth"), resultSet.getInt("org_year"), resultSet.getString("telephone"),
                        resultSet.getString("org_group"), resultSet.getString("login")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            // Обработка исключений
            e.printStackTrace();
        } finally {
            try {
                if (prSt != null) {
                    prSt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Обработка исключений при закрытии ресурсов
                e.printStackTrace();
            }
        }
        return list_users;
    }

    public ObservableList<TableUsers> GetAllStudent() {
        String select = "SELECT * FROM students WHERE login NOT IN ('null', 'administrator');";
        ObservableList<TableUsers> list_users = FXCollections.observableArrayList();
        Connection connection = null;
        PreparedStatement prSt = null;

        try {
            connection = getDbConnection();
            prSt = connection.prepareStatement(select);
            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()) {
                list_users.add(new TableUsers(resultSet.getInt("students_id"), resultSet.getString("org_name"),
                        resultSet.getString("date_birth"), resultSet.getInt("org_year"), resultSet.getString("telephone"),
                        resultSet.getString("org_group"), resultSet.getString("login")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            // Обработка исключений
            e.printStackTrace();
        } finally {
            try {
                if (prSt != null) {
                    prSt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Обработка исключений при закрытии ресурсов
                e.printStackTrace();
            }
        }
        return list_users;
    }
    public void deletingLine ( int id) throws SQLException, ClassNotFoundException {
        String insert = "DELETE FROM students WHERE students_id = " + id +";";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.executeUpdate();
    }


}
