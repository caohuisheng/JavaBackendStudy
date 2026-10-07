package com.itheima;

import java.awt.image.ColorConvertOp;
import java.util.*;

public class safeClass {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
        StringBuilder sb1 = new StringBuilder();

        Vector<String> v = new Vector<>();
        ArrayList<String> arrayList = new ArrayList<>();

        Hashtable<String,String> ht = new Hashtable<>();
        HashMap<String,String> hm = new HashMap<>();

        //同步时Vector和Hashtable被替代
        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        Map<String,String> kvMap = Collections.synchronizedMap(new HashMap<String, String>());
    }
}
