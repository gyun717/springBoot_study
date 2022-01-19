package co.mr.restapi02.mapper;

import co.mr.restapi02.model.Academy;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper // Mapper 인식
public interface AcademyMapper {
    @Insert("insert into academy(academy_name, academy_loc) values(#{academy.name}, #{academy.loc})")
    // 자동으로 생성되는 id값이 자바객체의 keyProperty = "id"에 생성되도록 설정
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("academy") Academy academy);

    @Select("select * from academy")
    @Results(id="academyMap", value={
            @Result(property = "name", column="academy_name"),
            @Result(property = "loc", column="academy_loc")
    })
    List<Academy> getAcademies();

    @ResultMap("academyMap")
    @Select("select * from academy where id=#{id}")
    Academy getById(int id);
}
