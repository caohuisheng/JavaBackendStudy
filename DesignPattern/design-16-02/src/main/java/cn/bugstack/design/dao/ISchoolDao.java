package cn.bugstack.design.dao;

import cn.bugstack.design.po.School;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-17
 */
public interface ISchoolDao {

    School querySchoolInfoById(Long treeId);

}
