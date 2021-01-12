package dao;

import model.Student;

import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/student?StudentSL=false";
    private String jdbcStudentname = "root";
    private String jdbcpassword = "1234567";
    private static final String INSERT_STUDENT_SQL = "INSERT INTO student" + "(name,sex,testScore) VALUES" + "(?,?,?);";
    private static final String SELECT_STUDENT_BY_ID = "select id, name,sex, testScore from student where id=?";
    private static final String SELECT_ALL_STUDENT = "select* from student";
    private static final String DELETE_STUDENT_SQL = "delete from student where is=?";
    private static final String UPDATE_STUDENT_SQL = "update student set name=?,sex=?, testScore=?,where id=?";

    public StudentDAO() {

    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcStudentname, jdbcpassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void insertStudent(Student student) throws SQLException {
        System.out.println(INSERT_STUDENT_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSex());
            preparedStatement.setInt(3, student.getTestScore());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Student selectStudent(int id) {
        Student student = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                int testScore = rs.getInt("testScore");
                student = new Student(id, name, sex, testScore);
            }


        } catch (SQLException e) {
            printSQLException(e);
        }
        return student;
    }

    public List<Student> selectAllStudent() {

        List<Student> student = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                int testScore = rs.getInt("testScore");
                student.add(new Student(id, name, sex, testScore));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return student;
    }

    public boolean deleteStudent(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateStudent(Student student) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT_SQL);) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getSex());
            statement.setInt(3, student.getTestScore());
            statement.setInt(4, student.getId());
            rowUpdated = statement.executeUpdate() > 0;

        }
        return rowUpdated;
    }

    @Override
    public Student getStudentById(int id) {
        Student student = null;
        String query = "{CALL get_user_by_id(?)}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                int testScore = rs.getInt("testScore");
                student = new Student(id, name, sex, testScore);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return student;
    }

    @Override
    public void insertStudentStore(Student student) throws SQLException {
        String query = "{CALL insert_user(?,?,?)}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setString(1, student.getName());
            callableStatement.setString(2, student.getSex());
            callableStatement.setInt(3, student.getTestScore());
            System.out.println(callableStatement);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("cause" + t);
                    t = t.getCause();
                }
            }
        }
    }
}




