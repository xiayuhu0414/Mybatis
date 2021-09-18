package org.example.dao;


import org.example.domian.Student;

import java.util.List;

public interface StudentDao {
    //动态SQL，使用java对象作为参数
    List<Student> selectStudentIf(Student student);

    //where使用
    List<Student> selectStudentWhere(Student student);

    //foreach 用法一
    List<Student> selectForeachOne(List<Integer> idlist);

    //foreach 用法二
    List<Student> selectForeachTwo(List<Student> stulist);

    //使用PageHelper分页数据
    List<Student> selectAll();
}
