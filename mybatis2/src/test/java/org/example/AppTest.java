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
