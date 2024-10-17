package cn.bugstack.design.dao;

import cn.bugstack.design.po.User;

import java.util.List;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-17
 */
public interface IUserDao {

    User queryUserInfoById(Long id);

    List<User> queryUserList(User user);

}
