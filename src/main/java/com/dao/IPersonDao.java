package com.dao;

import com.domain.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 持久层接口
 */
@Repository
public interface IPersonDao {
    @Select("select * from person")
    public List<Person> findAll();
    @Insert("insert into person(name,money) values (#{name},#{money})")
    public void savePerson(Person person);
}
