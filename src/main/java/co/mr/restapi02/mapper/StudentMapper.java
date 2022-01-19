package co.mr.restapi02.mapper;

import co.mr.restapi02.model.Academy;
import co.mr.restapi02.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    // 문제 >
    // 학생생성 API 만들기
    @Insert("insert into student(academy_id, student_name, student_tel) values(#{student.academyId},#{student.name}, #{student.tel})")
    // 자동으로 생성되는 id값이 자바객체의 keyProperty = "id"에 생성되도록 설정
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("student") Student student);

    // 모든 학생 조회하기
    @Select("select * from student")
    @Results(id="studentMap", value={
            @Result(property = "academyId" ,column = "academy_Id"),
            @Result(property = "name", column="student_name"),
            @Result(property = "tel", column="student_tel")
    })
    List<Student> getStudents();

    // 학생 ID를 이용하여 조회
    @ResultMap("studentMap")
    @Select("select * from student where id=#{id}")
    Student getById(int id);
}

