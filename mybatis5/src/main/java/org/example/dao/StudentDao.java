package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.domian.MyStudent;
import org.example.domian.Student;
import org.example.vo.QueryParam;
import org.example.vo.ViewStudent;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    public Student selectStudentById(@Param("studentId")  Integer id);

    List<Student> selectMulitParam(@Param("myname") String name, @Param("myage") Integer age);

    ViewStudent selectStudentReturnViewStudent(@Param("sid") Integer id);

    int countStudent();

    //定义方法返回Map
    Map<Object,Object> selectMapById(Integer id);

    //使用resultMap定义映射关系
    List<Student> selectAllSrtudent();

    List<MyStudent> selectMySrtudent();

    List<MyStudent> selectDiffColProperty();

    //第一种模糊查询，在java代码中指定like的内容
    List<Student> selectLikeOne(String name);
    //第一种模糊查询，在mapper文件中拼接like的内容
    List<Student> selectLikeTwo(String name);
}
