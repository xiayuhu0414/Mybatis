package org.example.dao;


import org.example.domian.Student;

import java.util.List;

public interface StudentDao {
    //动态SQL，使用java对象作为参数
    List<Student> selectStudentIf(Student student);

    //where使用
    List<Student> selectStudentWhere(Student student);
}
