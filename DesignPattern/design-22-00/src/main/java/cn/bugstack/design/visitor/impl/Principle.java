package cn.bugstack.design.visitor.impl;

import cn.bugstack.design.user.impl.Student;
import cn.bugstack.design.user.impl.Teacher;
import cn.bugstack.design.visitor.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: chs
 * Description: 校长
 * CreateTime: 2024-10-19
 */
public class Principle implements Visitor {

    private Logger log = LoggerFactory.getLogger(Principle.class);

    @Override
    public void visit(Student student) {
        log.info("学生信息 姓名：{} 班级：{}", student.name, student.clazz);
    }

    @Override
    public void visit(Teacher teacher) {
        log.info("老师信息 姓名：{} 班级：{} 升学率：{}", teacher.name, teacher.clazz, teacher.entranceRatio());
    }
}
