package com.min.dao.mapper;

import com.min.dao.dataobject.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    /**
     * 根据姓名查找
     *
     * @param name
     * @return
     */
    UserDO findUserByName(String name);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    @Select("SELECT * FROM user_info WHERE id = #{id}")
    UserDO findUserById(@Param("id") Long id);

    /**
     * 插入用户
     *
     * @param name
     */
    @Insert("INSERT INTO user_info (name) VALUES (#{name})")
    void insertUser(@Param("name") String name);

    /**
     * 查询所有
     *
     * @return
     */
    @Select("SELECT * FROM user_info")
    List<UserDO> findAll();
}
