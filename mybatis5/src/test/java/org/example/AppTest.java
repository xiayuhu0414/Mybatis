package org.example;

import static org.junit.Assert.assertTrue;

import com.sun.xml.internal.ws.runtime.config.TubelineDefinition;
import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domian.MyStudent;
import org.example.domian.Student;
import org.example.utils.MybatisUtils;
import org.example.vo.QueryParam;
import org.example.vo.ViewStudent;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void testSelectViewStudentById(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);

        ViewStudent student = dao.selectStudentReturnViewStudent(1001);

        System.out.println("student="+student);
    }
    @Test
    public void testSelectCount(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);

        int count = dao.countStudent();

        System.out.println("counts="+count);
    }

    @Test
    public void testSelectMap(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);

        Map<Object,Object> map = dao.selectMapById(1001);

        System.out.println("Map="+map);
    }

    //
    @Test
    public void testSelectAllStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectAllSrtudent();

        for(Student stu: students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMyStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<MyStudent> students = dao.selectMySrtudent();

        for(MyStudent stu: students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }
    @Test
    public void testselectDiffColProperty(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> students = dao.selectDiffColProperty();
        for(MyStudent stu: students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }

    @Test
    public void testLikeOne(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //准备好Like的内容
        String name ="%李%";
        List<Student> students = dao.selectLikeOne(name);
        for(Student stu: students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }

    @Test
    public void testLikeTwo(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //准备好Like的内容
        String name ="李";
        List<Student> students = dao.selectLikeTwo(name);
        for(Student stu: students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }
}
