package MyAnnotation;

public class getAnnotationTest {
    public static void main(String[] args) {
        Class<MyAnnotationTest> c = MyAnnotationTest.class;
        MyAnnotation annotation = c.getAnnotation(MyAnnotation.class);
        String[] names = annotation.names();
        for(String name:names){
            System.out.println(name);
        }
//        System.out.println(names.toString());
    }
}
