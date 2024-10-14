package cn.bugstack.design.lang;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-14
 */
public interface Iterable<E> {

    //获取迭代器
    Iterator<E> iterator();

}
