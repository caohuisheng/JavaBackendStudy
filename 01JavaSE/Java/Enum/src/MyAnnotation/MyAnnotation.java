package MyAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //保存在什么地方
@Target(ElementType.TYPE)   //用在什么地方
public @interface MyAnnotation {
//    String name() default "chs";
//    int age();
    String[] names();
}
