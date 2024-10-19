package cn.bugstack.design;

/**
 * Author: chs
 * Description: 活动状态枚举
 * CreateTime: 2024-10-19
 */
public enum Status {

    //创建编辑
    Editing,

    //待审核
    Check,

    //审核通过
    Pass,

    //审核拒绝
    Refuse,

    //活动中
    Doing,

    //活动关闭
    Close,

    //活动开启
    Open,

}
