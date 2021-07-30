package com.myapp.crud.mapper;

import com.myapp.crud.pojo.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("insert into product_ (name, price, cid) values (#{name}, #{price}, #{category.id})")
    void add(Product product);
    @Delete("delete from product_ where id=#{id}")
    void delete(int id);
    @Update("update product_ set name=#{name},price=#{price},cid=#{category.id} where id=#{id}")
    void update(Product product);
    @Select("select * from product_ where id=#{id}")
    @Results(
            @Result(property = "category", column = "cid",
            one = @One(select = "com.myapp.crud.mapper.CategoryMapper.get"))
    )
    Product get(int id);
    @Select("select * from product_")
    @Results(
            @Result(property = "category", column = "cid",
                    one = @One(select = "com.myapp.crud.mapper.CategoryMapper.get"))
    )
    List<Product> list();
    @Select("select * from product_ where cid=#{id}")
    @Results(
            @Result(property = "category", column = "cid",
                    one = @One(select = "com.myapp.crud.mapper.CategoryMapper.get"))
    )
    List<Product> listByCid(int id);
}
