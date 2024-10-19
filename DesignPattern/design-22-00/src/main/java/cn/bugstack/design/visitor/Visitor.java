package cn.bugstack.design.visitor;

import cn.bugstack.design.user.impl.Student;
import cn.bugstack.design.user.impl.Teacher;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-19
 */
public interface Visitor {

    void visit(Student student);

    void visit(Teacher teacher);

}
