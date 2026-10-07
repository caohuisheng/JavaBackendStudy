package Map;

import java.util.*;

public class PokerDemo {
    public static void main(String[] args) {
        //索引列表
        List<Integer> array = new ArrayList<>();
        //索引-牌
        HashMap<Integer,String> hs = new HashMap<>();

        //花色
        String[] colors = new String[]{"♦","♣","♥","♠"};
        //数字
        String[] numbers = new String[]{"3","4","5","6","7","8","9","10","J","Q","K","A","2"};

        //创建牌盒
        int index = 0;
        for(String num:numbers){
            for(String color:colors){
                array.add(index);
                hs.put(index,color+num);
                index++;
            }
        }
        array.add(index);
        hs.put(index,"小王");
        index++;
        array.add(index);
        hs.put(index,"大王");

        //洗牌
        Collections.shuffle(array);

        TreeSet<Integer> axSet = new TreeSet<>();
        TreeSet<Integer> xdSet = new TreeSet<>();
        TreeSet<Integer> hySet = new TreeSet<>();
        TreeSet<Integer> dpSet = new TreeSet<>();

        //发牌
        for(int i=0;i<array.size();i++){
            int x = array.get(i);
            if(i>=array.size()-3){
                dpSet.add(x);
            }else if(i%3==0){
                axSet.add(x);
            }else if(i%3==1){
                xdSet.add(x);
            }else{
                hySet.add(x);
            }
        }

        //看牌
        lookPoker("阿星",axSet,hs);
        lookPoker("小刀",xdSet,hs);
        lookPoker("洪爷",hySet,hs);
        lookPoker("底牌",dpSet,hs);
    }

    public static void lookPoker(String name,TreeSet<Integer> ts,HashMap<Integer,String> hs){
        System.out.println(name+"的牌：");
        for(Integer i:ts){
            String poker = hs.get(i);
            System.out.print(poker+" ");
        }
        System.out.println();
    }
}
