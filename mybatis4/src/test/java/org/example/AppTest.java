package org.example;

import static org.junit.Assert.assertTrue;

import com.sun.xml.internal.ws.runtime.config.TubelineDefinition;
import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domian.Student;
import org.example.utils.MybatisUtils;
import org.example.vo.QueryParam;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testSelectStudentById(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);

        Student student = dao.selectStudentById(1001);

        System.out.println("student="+student);
    }

    @Test
    public void testSelectMultiParam(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectMulitParam("李四",20);

        for(Student stu: students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiObject(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        QueryParam param = new QueryParam();
        param.setParamName("张三");
        param.setParamAge(28);
        List<Student> students = dao.selectMultiObject(param);

        for(Student stu: students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectMultiStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student  = new Student();
        student.setName("张三");
        student.setAge(28);

        List<Student> students = dao.selectMultiStudent(student);

        for(Student stu: students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiPosition(){
        SqlSession sqlSession =MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.seelectMultiPositior("李四",20);

        for(Student stu: students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }

}
