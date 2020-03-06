package com.cuit.springboot.mapper;

import com.cuit.springboot.entities.Provider;
import com.cuit.springboot.entities.User;

import java.util.List;

/**
 * @version JDK  1.8.151
 * @Author: Mirrors
 * @Description: Chengdu City
 */

public interface UserMapper {

    User getUserByUsername(String username);

    List<User> getUsers(User user);//为啥直接传Provider而不是ProviderName 不扩展功能直接传入实体

    User getUserById(Integer id);

    int addUser(User user);

    int deleteUserById(Integer id);

    int updateUser(User user);

}
