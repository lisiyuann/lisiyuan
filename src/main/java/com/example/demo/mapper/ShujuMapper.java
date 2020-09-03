package com.example.demo.mapper;

import com.example.demo.model.Shuju;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface ShujuMapper{
    @Insert("insert into shuju (biaoti,date) values (#{biaoti},#{date})")
    void addshuju(Shuju shuju);
    @Select("select * from shuju where biaoti=#{biaoti}")
    Shuju  getshuju(String biaoti);

    @Select("select biaoti from shuju ")
    List<String> findAll();

    @Select("select date from shuju where  biaoti=#{biaoti}")
    String neirong(String  biaoti);//获取对应的数据
    @Delete("delete from shuju where biaoti=#{biaoti}")
    void deleteshuju(String biaoti);
    @Update("update shuju set date=#{date} where biaoti=#{biaoti}")
    void updateshuju(String biaoti,String date);

}