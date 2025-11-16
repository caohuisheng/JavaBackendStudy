package cn.itcast.n5;

public class TestVolatile {

    volatile boolean initialized = false;
    static boolean run = true;

    void init() {
        if (initialized) {
            return;
        }
        doInit();
        initialized = true;
    }

    private void doInit() {

    }

    public static void main(String[] args) {
        new Thread(()->{
            while(run){

            }
        },"t1").start();
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){}
        run = false;
    }
}
