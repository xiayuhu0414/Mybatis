package org.example.dao;

import org.example.domian.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudent();
    Integer insertStudent(Student student);
}
