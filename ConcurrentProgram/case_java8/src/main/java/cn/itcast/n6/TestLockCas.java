package cn.itcast.n6;

import cn.itcast.test.LockCas;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j(topic = "c.TestLockCas")
public class TestLockCas {
    private LockCAS lock = new LockCAS();

    void test(){
        new Thread(()->{
            lock.lock();
            log.debug("lock...");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){}
            lock.unLock();
            log.debug("unLock...");
        }).start();

        new Thread(()->{
            lock.lock();
            log.debug("lock...");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){}
            lock.unLock();
            log.debug("unLock...");
        }).start();
    }

    public static void main(String[] args) {
        new TestLockCas().test();
    }

}

class LockCAS{
    private AtomicInteger state = new AtomicInteger(0);

    public void lock(){
        while(true){
            if(state.compareAndSet(0,1)) break;
        }
    }

    public void unLock(){
        state.set(0);
    }
}

