package Map;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class CountNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = sc.nextLine();

        HashMap<Character,Integer> hs = new HashMap<>();

        for(int i=0;i<str.length();i++){
            Character c = str.charAt(i);
            Integer value = hs.get(c);
            if(value == null){
                hs.put(c,1);
            }else{
                hs.put(c,value+1);
            }
        }

        Set<Character> keySet = hs.keySet();
        StringBuilder sb = new StringBuilder();
        for(Character c:keySet){
            Integer value = hs.get(c);
            sb.append(c).append("(").append(value).append(")");
        }
        System.out.println(sb.toString());
    }
}
