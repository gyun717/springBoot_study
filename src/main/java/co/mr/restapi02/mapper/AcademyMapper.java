package co.mr.restapi02.mapper;

import co.mr.restapi02.model.Academy;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper // Mapper 인식
public interface AcademyMapper {
    @Insert("insert into academy(academy_name, academy_loc) values(#{academy.name}, #{academy.loc})")
    int insert(@Param("academy") Academy academy);

    @Select("select * from academy")
    @Results({
            @Result(property = "name", column="academy_name"),
            @Result(property = "loc", column="academy_loc")
    })
    List<Academy> getAcademies();
}
