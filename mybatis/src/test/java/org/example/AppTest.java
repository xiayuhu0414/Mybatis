package org.example;

import static org.junit.Assert.assertTrue;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.Student;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
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
    public void shouldAnswerWithTrue() throws IOException {
        //访问mybatis读取student数据
        //1.定义mybatis主配置文件的名称, 从类路径的根开始（target/clasess）
        String config="mybatis.xml";
        //2.读取这个config表示的文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建了SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder  = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5.获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        //SqlSession sqlSession = factory.openSession();  手动提交事务
        SqlSession sqlSession = factory.openSession(true);
        //6.【重要】指定要执行的sql语句的标识。  sql映射文件中的namespace + "." + 标签的id值
        //String sqlId = "com.bjpowernode.dao.StudentDao" + "." + "selectStudents";
        String sqlId = "org.example.dao.StudentDao.insertStudent";
        //7. 重要】执行sql语句，通过sqlId找到语句
        Student student=new Student(1004,"张即","2324832@128.com",14);
        int nums = sqlSession.insert(sqlId,student);
        //mybatis默认不是自动提交事务，所以在insert,updata,delete后要手工提交事务
       // sqlSession.commit();
        //8.输出结果
        //studentList.forEach( stu -> System.out.println(stu));
        System.out.println(nums);
        //9.关闭SqlSession对象
        sqlSession.close();

    }


}
