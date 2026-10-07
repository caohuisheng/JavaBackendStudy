package Set;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class RandomNum_demo {
    public static void main(String[] args) {
//        HashSet<Integer> hs = new HashSet<>();
        TreeSet<Integer> hs = new TreeSet<>();
        Random random = new Random();

        int count = 0;
        while(hs.size()<10){
            int x = random.nextInt(20) + 1;
            hs.add(x);
            count++;
        }
        System.out.println("count:"+count);
        for(Integer x:hs){
            System.out.println(x);
        }
    }
}
