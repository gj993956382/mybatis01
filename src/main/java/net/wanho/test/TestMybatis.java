package net.wanho.test;

import net.wanho.mapper.StudentMapper;
import net.wanho.pojo.Student;
import net.wanho.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2019/6/5.
 */
public class TestMybatis {
    private SqlSession sqlSession;
    private StudentMapper studentMapper;

    @Before
    public void before() {
//        InputStream inputStream = TestMybatis.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
//        sqlSession = sf.openSession();
        sqlSession = MybatisUtil.getSqlSession();
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    @Test
    public void testAddStu() {
        Student student = new Student(null, "zhangsan", 14, "男", "南京");
//        sqlSession.update("net.wanho.mapper.StudentMapper.addStu",student);
//        sqlSession.commit();
//        sqlSession.close();
//        SqlSession session = MybatisUtil.getSqlSession();
//        session.update("net.wanho.mapper.StudentMapper.addStu", student);
//        System.out.println(student.getId());
//        session.commit();
        studentMapper.addStu(student);
        System.out.println(student.getId());
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void updateStudent() {
        Student student = new Student(null, "lisi", 16, "男", "南京");
        SqlSession session = MybatisUtil.getSqlSession();
        session.update("net.wanho.mapper.StudentMapper.updateStu", student);
        session.commit();
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void delStudent() {
        SqlSession session = MybatisUtil.getSqlSession();
        session.update("net.wanho.mapper.StudentMapper.delStu", 2);
        session.commit();
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void getAllStudent() {
        SqlSession session = MybatisUtil.getSqlSession();
        List<Student> list = session.selectList("net.wanho.mapper.StudentMapper.getAllStus");
        System.out.println(list);
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void getStudent() {
//        SqlSession session = MybatisUtil.getSqlSession();
//        Student student = session.selectOne("net.wanho.mapper.StudentMapper.getStuById", 1);
//        System.out.println(student);
//        MybatisUtil.closeSqlSession();
        Student student = studentMapper.getStuById(1);
        System.out.println(student);
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void getStudentByName() {
//        SqlSession session = MybatisUtil.getSqlSession();
//        Student student = session.selectOne("net.wanho.mapper.StudentMapper.getStuById", 1);
//        System.out.println(student);
//        MybatisUtil.closeSqlSession();
        Student student = new Student();
        student.setSname("zhang");
        List<Student> list = studentMapper.getStuByName(student);
        System.out.println(list);
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void selectCount() {
        Integer count = studentMapper.selectCount();
        System.out.println(count);
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void testAddStuReturnKey() {
        Student student = new Student(null, "zhangsan", 14, "男", "南京");
        studentMapper.addStuReturnKey(student);
        System.out.println(student.getId());
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void testUpdateStu1() {
        Student student = new Student(null, "王五", 14, "男", "南京");
        studentMapper.updateStuById(9, "王五", "上海", 15);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void testUpdateStu2() {
        Student student = new Student(null, "李四", 14, "男", "南京");
        studentMapper.updateStuById2(8, student);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void getAllStudent2() {
        List<Student> list = studentMapper.getAllStus2();
        System.out.println(list);
        MybatisUtil.closeSqlSession();
    }
    @Test
    public void getStudent2() {
        Student student = studentMapper.getStuById2(1);
        System.out.println(student);
        MybatisUtil.closeSqlSession();
    }
}
