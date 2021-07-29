package com.myapp.crud.mapper;

import com.myapp.crud.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CategoryMapper {
    @Insert("insert into category_ (name) values (#{name})")
    void add(Category category);
    @Delete("delete from category_ where id=#{id}")
    void delete(int id);
    @Update("update category_ set name=#{name} where id=#{id}")
    void update(Category category);
    @Select("select * from category_ where id=#{id}")
    Category get(int id);
    @Select("select * from category_")
    List<Category> list();
}
