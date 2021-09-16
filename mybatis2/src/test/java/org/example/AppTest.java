package org.example;

import static org.junit.Assert.assertTrue;

import org.example.dao.StudentDao;
import org.example.dao.impl.StudentDaoImpl;
import org.example.domian.Student;
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
    @Test
    public void shouldAnswerWithTrue()
    {
        StudentDao dao=new StudentDaoImpl();
        /*
        * List<Student> studentList=dao.selectStudent();  调用
        * 1.dao对象，类型是studentD，全限定名称是：
        *
        * 2.方法名称，selectScent，这个方法就是mapper文件中的id值selectStudent
        *
        * 3.通过dao中方法的返回值也可以确定mybatis要调用的SQLsession的方法
        *   如果返回值是list，调用的是Sqlsession。selectList（）方法。
        *   如果返回值是int，或是非List，看mapper文件中的标签是<insert>,<update>就会调用
        *   Sqlsession的insert，update等方法
        *
        * mybatis的动态代理：mybatis根据到的方法调用，获取执行SQL语句的信息。
        *     mybatis根据你的dao接口，创建出一个dao接口的实现类，并创建这个类的对象。
        *    完成SqlSession调用方法，访问数据库。
        * */
        List<Student> studentList=dao.selectStudent();
        for (Student stu:studentList){
            System.out.println(stu);
        }
    }
    @Test
    public void test(){
        StudentDao dao=new StudentDaoImpl();
        Student student=new Student(1005,"夏季","13378217@165.com",23);
        int nums=dao.insertStudent(student);
        System.out.println("数量为："+nums);
    }
}
