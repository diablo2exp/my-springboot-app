package com.example.demo.mapper;

import com.example.demo.model.Casuser;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CasuserMapper {
  
    @Select("SELECT * FROM casuser WHERE cas_id = #{id} AND cas_pass = #{password}")
    Casuser findUserByUsernameAndPassword(String id, String password);
}
