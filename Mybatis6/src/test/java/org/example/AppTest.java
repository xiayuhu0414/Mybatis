package org.example;

import static org.junit.Assert.assertTrue;

import com.sun.xml.internal.ws.runtime.config.TubelineDefinition;
import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domian.Student;
import org.example.utils.MybatisUtils;
import org.example.vo.QueryParam;
import org.junit.Test;

import java.util.ArrayList;
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

    @Test
    public void testFor(){
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        list.add(1004);

        //String sql = "select * from student where id in (1001,1002,1003)"
        String sql="select * from student where id in";
        StringBuilder builder = new StringBuilder("");
        int  init =0;
        int len=list.size();

        //添加开始的（
        builder.append("(");
        for(Integer i :list){
            builder.append(i).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        //循环结尾
        builder.append(")");
        sql=sql+builder.toString();
        System.out.println("sql==" + sql);
    }
    @Test
    public void testSelectForeach(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        list.add(1004);
        List<Student> students=dao.selectForeachOne(list);
        for(Student stu :students){
            System.out.println("foreach---one===" + stu);
        }
    }

    @Test
    public void testSelectForeachTwo(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);
        List<Student> stuList = new ArrayList<>();
        Student s1 =new Student();
        Student s2 = new Student();
        s1.setId(1003);
        s2.setId(1004);
        stuList.add(s1);
        stuList.add(s2);
        List<Student> students=dao.selectForeachTwo(stuList);
        for(Student stu :students){
            System.out.println("foreach---two===" + stu);
        }
    }
}
