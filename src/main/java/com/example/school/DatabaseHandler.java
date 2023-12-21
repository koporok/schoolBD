package com.example.school;

import com.example.school.classes.Coach;
import com.example.school.classes.Student;
import com.example.school.table.TableCoach;
import com.example.school.table.TableStudentCoachClasses;
import com.example.school.table.TableStudents;
import com.example.school.table.TableUsers;
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

    //добавляем тренера
    public void signCoach(Coach coach) {
        String insert = "INSERT INTO coaches (CoachFIO, CoachTelephone, CoachLogin)"
                + "VALUES(?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, coach.getCoachFIO());
            prSt.setString(2, coach.getCoachTelephone());
            prSt.setString(3, coach.getCoachLogin());

            prSt.executeUpdate();
        }
        catch (SQLException e) {throw new RuntimeException(e);}
        catch (ClassNotFoundException e) {throw new RuntimeException(e);}
    }

    // добавляем пользователя (как заявка)
    public void signUser(Student student) {
        String insert = "INSERT INTO students (org_name, date_birth, org_year, telephone, groupid, login)"
                + "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, student.getStudentsFIO());
            prSt.setString(2, student.getStudentsDate());
            prSt.setInt(3, student.getStudentsYear());
            prSt.setString(4, student.getStudentsTelephone());
            prSt.setInt(5, student.getIDgroups());
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

    public void addStudentAttendance(int id) throws SQLException {
        String select = "INSERT INTO Attendance (students_id, scheduleid, attendance_flag)"
                + "VALUES(?, 1,, '0' )"; // Определение запроса SQL
        try {
            Connection connection = getDbConnection(); // получение соединения с базой данных
            PreparedStatement prSt = connection.prepareStatement(select);
            prSt.setInt(1, id);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Обработка исключений
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    //добавляем логин и пользователь становится учеником (меджик)
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

    //берё данные для таблицы заявок
    public ObservableList<TableUsers> GetAllUsers() {
        String select = "SELECT * FROM students\n" +
                "JOIN groups ON students.groupid = groups.groupid\n" +
                "WHERE login = 'null';";
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
                        resultSet.getInt("groupid"), resultSet.getString("login")));
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

    public ObservableList<TableStudents> GetAllStudeht1() {
        String select = "SELECT * FROM students\n" +
                "JOIN groups ON students.groupid = groups.groupid\n" +
                "WHERE login <> 'null';";
        ObservableList<TableStudents> list_users = FXCollections.observableArrayList();
        Connection connection = null;
        PreparedStatement prSt = null;

        try {
            connection = getDbConnection();
            prSt = connection.prepareStatement(select);
            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()) {
                list_users.add(new TableStudents(resultSet.getInt("students_id"), resultSet.getString("org_name"),
                        resultSet.getString("date_birth"), resultSet.getInt("org_year"), resultSet.getString("telephone"),
                        resultSet.getInt("groupid"), resultSet.getString("login"), resultSet.getInt("groupid"), resultSet.getString("group_name"), resultSet.getInt("min_age"), resultSet.getInt("max_age"), resultSet.getInt("max_students"), resultSet.getInt("coachid")));
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

    public ObservableList<TableCoach> GetAllCoach() {
        String select = "SELECT * FROM coaches;";
        ObservableList<TableCoach> list_users = FXCollections.observableArrayList();
        Connection connection = null;
        PreparedStatement prSt = null;

        try {
            connection = getDbConnection();
            prSt = connection.prepareStatement(select);
            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()) {
                list_users.add(new TableCoach(resultSet.getInt("coachid"), resultSet.getString("coachfio"),
                        resultSet.getString("coachtelephone"), resultSet.getString("coachlogin")));
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



    public ObservableList<TableStudentCoachClasses> GetAllStudent() {
        String select = "SELECT *\n" +
                "FROM Attendance\n" +
                "JOIN Students ON Attendance.students_id = Students.students_id\n" +
                "JOIN Lesson_schedule ON Attendance.scheduleid = Lesson_schedule.scheduleid\n" +
                "JOIN Groups ON Students.groupid = Groups.groupid\n" +
                "JOIN Coaches ON Lesson_schedule.coachid = Coaches.coachid\n" +
                "WHERE Students.login <> 'null'";
        ObservableList<TableStudentCoachClasses> list = FXCollections.observableArrayList();
        Connection connection = null;
        PreparedStatement prSt = null;

        try {
            connection = getDbConnection();
            prSt = connection.prepareStatement(select);
            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()) {
                list.add(new TableStudentCoachClasses(resultSet.getInt("attendanceid"), resultSet.getInt("students_id"), resultSet.getInt("scheduleid"), resultSet.getBoolean("attendance_flag"),
                        resultSet.getInt("students_id"), resultSet.getString("org_name"), resultSet.getString("date_birth"), resultSet.getInt("org_year"), resultSet.getString("telephone"), resultSet.getInt("groupid"), resultSet.getString("login"),
                        resultSet.getInt("scheduleid"), resultSet.getInt("group_id"), resultSet.getDate("lesson_date"), resultSet.getString("time"), resultSet.getInt("coachid"),
                        resultSet.getInt("groupid"), resultSet.getString("group_name"), resultSet.getInt("min_age"), resultSet.getInt("max_age"), resultSet.getInt("max_students"), resultSet.getInt("coachid"),
                        resultSet.getInt("coachid"), resultSet.getString("coachfio"), resultSet.getString("coachtelephone"), resultSet.getString("coachlogin")));
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
        return list;
    }

    public void deletingLine (String nameTable,String column, int id) throws SQLException, ClassNotFoundException {
        String insert = "DELETE FROM "+nameTable+" WHERE "+column+" = " + id +";";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.executeUpdate();
    }


}
