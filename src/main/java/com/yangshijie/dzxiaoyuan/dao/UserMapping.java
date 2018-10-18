package com.yangshijie.dzxiaoyuan.dao;

import com.yangshijie.dzxiaoyuan.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yangshijie
 */
public interface UserMapping {
    /**
     * @return
     */
    @Select("select * from user")
    List<User> findUserById();


    /**
     * @param id
     * @return
     */
    User getUserById(String id);

   // @Insert("insert into user (name,phone,sfid) values(#{name},#{phone},#{sfid})")
    void addUser(User user);





}
