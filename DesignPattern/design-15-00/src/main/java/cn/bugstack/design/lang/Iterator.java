package cn.bugstack.design.lang;

/**
 * Author: chs
 * Description: 迭代器接口
 * CreateTime: 2024-10-14
 */
public interface Iterator<E> {

    boolean hasNext();

    E next();

}
