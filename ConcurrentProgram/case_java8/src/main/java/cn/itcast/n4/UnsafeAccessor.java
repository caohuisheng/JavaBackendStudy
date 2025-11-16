package cn.itcast.n4;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Set;

public class UnsafeAccessor {
    private static final Unsafe unsafe;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new Error(e);
        }
        "".hashCode();
    }

    public static Unsafe getUnsafe() {
        return unsafe;
    }
}
