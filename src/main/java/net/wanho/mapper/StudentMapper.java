package net.wanho.mapper;

import net.wanho.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2019/6/5.
 */
public interface StudentMapper {
    List<Student> getAllStus();

    void updateStu(Student student);

    void delStu(Integer id);

    void addStu(Student student);

    Student getStuById(Integer id);

    List<Student> getStuByName(Student student);

    Integer selectCount();

    Integer addStuReturnKey(Student student);

    void updateStuById(@Param("id") Integer id,@Param("sname")String sname,@Param("address")String address,@Param("age")Integer age);
    void updateStuById2(@Param("id") Integer id,@Param("stu")Student student);

    @Select("SELECT * from student")
    List<Student> getAllStus2();

    @Select("SELECT * from student where id=#{id}")
    Student getStuById2(Integer id);
}
