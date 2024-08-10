package com.ccnu.chapter6.unsafe_test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-08-10
 */
public class UnsafeAccessor {
    static Unsafe unsafe;

    static {
        try{
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
        }catch(NoSuchFieldException | IllegalAccessException e){
            throw new Error(e);
        }
    }

    static Unsafe getUnsafe(){
        return unsafe;
    }
}
