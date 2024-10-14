package cn.bugstack.design.lang;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-14
 */
public interface Collection<E, L> extends Iterable<E> {

    boolean add(E e);

    boolean remove(E e);

    boolean addLink(String key, L link);

    boolean removeLink(String key);

}
