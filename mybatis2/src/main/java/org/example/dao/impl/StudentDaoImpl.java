package org.example.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domian.Student;
import org.example.utils.MybatisUtils;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudent() {
        //获取是sqlsession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        String sqlId="org.example.dao.StudentDao.selectStudent";
        //执行sql语句，使用sqlsession类的方法
        List<Student>students=sqlSession.selectList(sqlId);
        //关闭
        sqlSession.close();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        //获取是sqlsession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        String sqlId="org.example.dao.StudentDao.insertStudent";
        //执行sql语句，使用sqlsession类的方法
        int nums= sqlSession.insert(sqlId,student);
        //提交事务
        sqlSession.commit();
        //关闭
        sqlSession.close();
        return nums;    }
}
