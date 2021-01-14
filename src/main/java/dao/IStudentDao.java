package dao;

import model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDao {
    public  void insertStudent(Student student)throws SQLException ;
    public Student selectStudent(int id);
    public List<Student>selectAllStudent();
    public boolean deleteStudent(int id)throws SQLException;
    public  boolean updateStudent(Student student) throws SQLException;

    public Student getStudentById(int id);

    public void insertStudentStore(Student student) throws SQLException;
}
