package Set;

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(100);
        ts.add(50);
        ts.add(60);
        ts.add(20);

        for(Integer t:ts){
            System.out.println(t+" ");
        }
    }
}
