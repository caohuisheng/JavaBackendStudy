package Set;

public class HashCodeDemo {
    public static void main(String[] args) {
        System.out.println("hello".hashCode());
        System.out.println("world".hashCode());
        System.out.println("java".hashCode());
        System.out.println("world".hashCode());
        System.out.println("--------");

        //string类重写了hashCode方法
        System.out.println("重地".hashCode());
        System.out.println("通话".hashCode());
    }
}
