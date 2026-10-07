package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo1 {
    public static void main(String[] args) {
        //创建集合对象
        Collection<String> c = new ArrayList<String>();

        //添加元素
        c.add("hello");
        c.add("world");
        c.add("hello");

        //获取迭代器对象
        Iterator<String> it = c.iterator();
        System.out.println(it);
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
