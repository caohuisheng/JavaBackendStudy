package annotation;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        @SuppressWarnings(value = "all")    //取消警告
        List<String> list = new ArrayList();

        Father f1 = new Father();
        f1.method();
    }
}
