package org.example;

import static org.junit.Assert.assertTrue;

import com.sun.xml.internal.ws.runtime.config.TubelineDefinition;
import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domian.Student;
import org.example.utils.MybatisUtils;
import org.example.vo.QueryParam;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testSelectStudentIf(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        student.setName("李四");
        student.setAge(18);
        List<Student> students=dao.selectStudentIf(student);
        for(Student stu :students){
            System.out.println("if===" + stu);
        }
    }
    @Test
    public void testSelectStudentWhere(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        student.setName("李四");
        student.setAge(18);
        List<Student> students=dao.selectStudentWhere(student);
        for(Student stu :students){
            System.out.println("where===" + stu);
        }
    }

}
