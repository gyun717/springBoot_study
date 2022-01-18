package co.mr.restapi02.mapper;

import co.mr.restapi02.model.Academy;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper // Mapper 인식
public interface AcademyMapper {
    @Insert("insert into academy(academy_name, academy_loc) values(#{academy.name}, #{academy.loc})")
    int insert(@Param("academy") Academy academy);
}
