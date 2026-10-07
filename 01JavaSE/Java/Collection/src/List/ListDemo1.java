package List;

import java.util.ArrayList;
import java.util.List;

public class ListDemo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String s1 = "hello";
        String s2 = "world";
        String s3 = "java";

        list.add(s1);
        list.add(s2);
        list.add(s3);

        /*Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            if(s.equals("world")){
                list.add("javaee");
            }
            //System.out.println(s);
        }*/

        for(int i=0;i<list.size();i++){
            String s = list.get(i);
            if(s.equals("world")){
                list.add("javaee");
            }
        }
        System.out.println(list);
    }
}
