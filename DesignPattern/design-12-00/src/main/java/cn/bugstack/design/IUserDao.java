package cn.bugstack.design;

import cn.bugstack.design.agent.Select;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-13
 */
public interface IUserDao {

    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String uId);

}
