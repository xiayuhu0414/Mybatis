package org.example;

import static org.junit.Assert.assertTrue;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;import org.example.domian.Student;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
/*    @Test
    public void shouldAnswerWithTrue()
    {
        StudentDao dao=new StudentDaoImpl();
        List<Student> studentList=dao.selectStudent();
        for (Student stu:studentList){
            System.out.println(stu);
        }
    }*/
/*
    @Test
    public void test(){
        StudentDao dao=new StudentDaoImpl();
        Student student=new Student(1005,"夏季","13378217@165.com",23);
        int nums=dao.insertStudent(student);
        System.out.println("数量为："+nums);
    }
*/

    @Test
    public void test1(){
        /*
        * 使用mybatis的动态代理机制，使用SqlSession.getMapper(dao接口)
        * getMapper能获取dao接口对于实现类对象
        *
        * */
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        //调用dao方法，执行数据库操作
        List<Student> students=dao.selectStudent();
        for (Student stu:students){
            System.out.println(stu);
        }
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student studentt = new Student(1006,"瑞瑞","13378217@165.com",24);
        System.out.println(studentt);
        Integer nums = dao.insertStudent(studentt);
        sqlSession.commit();
        System.out.println(nums);
        sqlSession.close();
    }
}
