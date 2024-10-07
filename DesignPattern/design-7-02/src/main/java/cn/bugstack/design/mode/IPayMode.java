package cn.bugstack.design.mode;

/**
 * Author: chs
 * Description: 校验方式接口
 * CreateTime: 2024-10-07
 */
public interface IPayMode {

    boolean security(String uId);

}
