package com.ccnu.chapter8;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Author: chs
 * Description: ConcurrentHashMap测试
 * CreateTime: 2024-08-17
 */
public class ConcurrentHashMapTest {

    private static void generateFile(){
        int count = 200;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            for (int j = 0; j < count; j++) {
                list.add(String.valueOf(ch));
            }
        }
        Collections.shuffle(list);
        for (int i = 0; i < 26; i++) {
            try{
                File file = new File("src/main/resources/file");
                if(!file.exists()){
                    file.mkdirs();
                }
                PrintWriter out = new PrintWriter("src/main/resources/file/" + (i+1) + ".txt");
                String collect = list.subList(i * count, (i + 1) * count).stream().collect(Collectors.joining("\n"));
                out.print(collect);
                out.flush();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    private static <V> void demo(Supplier<Map<String,V>> supplier, BiConsumer<Map<String,V>, List<String>> consumer){
        Map<String, V> counterMap = supplier.get();
        List<Thread> ts = new ArrayList<>();
        for (int i = 1; i <= 26; i++) {
            int idx = i;
            Thread thread = new Thread(() -> {
                List<String> words = readFromFile(idx);
                consumer.accept(counterMap, words);
            });
            ts.add(thread);
        }
        ts.forEach(Thread::start);
        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(counterMap);
    }

    private static List<String> readFromFile(int idx){
        try(
                BufferedReader br = new BufferedReader(new FileReader("src/main/resources/file/" + idx + ".txt"));
                ){
            List<String> words = new ArrayList<>();
            while(true){
                String word = br.readLine();
                if(word == null) break;
                words.add(word);
            }
            return words;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        //方法1.线程不安全
        //demo(
        //        () -> new HashMap<String,Integer>(),
        //        (map,words) -> {
        //            for (String word : words) {
        //                map.put(word, map.getOrDefault(word, 0) + 1);
        //            }
        //        }
        //);
        //方法2
        //demo(
        //        () -> new ConcurrentHashMap<String,Integer>(),
        //        (map,words) -> {
        //            for (String word : words) {
        //                //map.put(word, map.getOrDefault(word, 0) + 1);
        //                map.merge(word, 1, Integer::sum);
        //            }
        //        }
        //);
        //方法3
        demo(
                () -> new ConcurrentHashMap<String, LongAdder>(),
                (map,words) -> {
                    for (String word : words) {
                        map.computeIfAbsent(word, key -> new LongAdder()).increment();
                    }
                }
        );
    }
}
