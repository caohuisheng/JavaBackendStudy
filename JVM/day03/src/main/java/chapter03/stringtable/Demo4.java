package chapter03.stringtable;

/**
 * intern案例
 */
public class Demo4 {
    public static void main(String[] args) {
        String s1 = new StringBuilder().append("think").append("123").toString();
        System.out.println(s1.intern() == s1); //true
        String s2 = new StringBuilder().append("ja").append("va").toString(); //false
        System.out.println(s2.intern() == s2);
    }
}
