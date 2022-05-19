package com.javawebstudy.mybatis.mapper;

import com.javawebstudy.mybatis.User;

import java.util.List;

/**
 * @author Jiahao Wang
 * @Description
 * @create 2022-05-19 09:25
 */
public interface UserMapper {

	List<User> selectAll();
}
