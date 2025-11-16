package cn.itcast;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j(topic="c.TestMyThreadPool")
public class TestMyThreadPool {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(1,1,1000,TimeUnit.MILLISECONDS,(queue,task)->{
            //1.死等
            //queue.put(task);
            //2.超时等待
            //queue.offer(task,1000,TimeUnit.MILLISECONDS);
            //3.让调用者放弃任务执行
            //log.debug("放弃任务：{}",task);
            //4.抛出异常
            //throw new RuntimeException("任务执行失败："+task);
            //5.让调用者自己执行任务
            task.run();
        });
        for(int i=0;i<4;i++){
            int j=i;
            Runnable task = ()->{
                //log.debug("任务开始执行: task{}",j);
                log.debug("begin task:{}",j);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){}
            };
            threadPool.execute(task);
        }
    }
}

@FunctionalInterface
interface RejectPolicy<T>{
    void reject(BlockingQueue<T> blockingQueue,T task);
}

@Slf4j(topic="c.ThreadPool")
class ThreadPool{
    private int coreSize;
    private int queueSize;
    private long timeOut;
    private TimeUnit timeUnit;
    private RejectPolicy<Runnable> rejectPolicy;
    private List<Worker> workers = new ArrayList<>();
    private BlockingQueue<Runnable> taskQueue;

    public ThreadPool(int coreSize, int queueSize, long timeOut, TimeUnit timeUnit, RejectPolicy<Runnable> rejectPolicy) {
        this.coreSize = coreSize;
        this.queueSize = queueSize;
        this.timeOut = timeOut;
        this.timeUnit = timeUnit;
        this.rejectPolicy = rejectPolicy;
        this.taskQueue = new BlockingQueue<>(queueSize);
    }

    public void execute(Runnable task){
        synchronized(workers){
            if(workers.size() < coreSize){
                Worker worker = new Worker(task);
                log.debug("添加worker:{}",worker);
                workers.add(worker);
                worker.start();
            }else{
                taskQueue.tryPut(rejectPolicy,task);
            }
        }
    }

    class Worker extends Thread{
        private Runnable task;

        public Worker(Runnable task){
            this.task = task;
        }

        @Override
        public void run() {
            while(task!=null || (task=taskQueue.poll(timeOut,timeUnit))!=null){
                try{
                    log.debug("正在执行：{}",task);
                    task.run();
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    task = null;
                }
            }
            log.debug("删除worker:{}",this);
            workers.remove(this);
        }
    }

}

@Slf4j(topic="c.BlockingQueue")
class BlockingQueue<T>{
    private Deque<T> queue = new ArrayDeque<T>();
    private ReentrantLock lock = new ReentrantLock();
    private Condition fullWaitSet = lock.newCondition();
    private Condition emptyWaitSet = lock.newCondition();
    private int capacity;

    public BlockingQueue(int capacity){
        this.capacity = capacity;
    }

    public void put(T task){
        lock.lock();
        try{
            while(queue.size()==capacity){
                try{
                    log.debug("等待加入任务队列：{}",task);
                    fullWaitSet.await();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            log.debug("添加任务到队列：{}",task);
            queue.addLast(task);
            emptyWaitSet.signal();
        }finally{
            lock.unlock();
        }
    }

    public boolean offer(T task,long timeOut,TimeUnit timeUnit){
        lock.lock();
        try{
            long timeOutNanos = timeUnit.toNanos(timeOut);
            while(queue.size()==capacity){
                if(timeOutNanos <= 0) return false;
                try{
                    log.debug("等待加入任务到队列：{}",task);
                    timeOutNanos = fullWaitSet.awaitNanos(timeOutNanos);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            log.debug("加入任务到队列：{}",task);
            queue.addLast(task);
            emptyWaitSet.signal();
            return true;
        }finally{
            lock.unlock();
        }
    }

    public void tryPut(RejectPolicy<T> rejectPolicy,T task){
        lock.lock();
        try{
            if(queue.size() == capacity){
                rejectPolicy.reject(this,task);
                return;
            }
            log.debug("加入任务到队列：{}",task);
            queue.addLast(task);
            emptyWaitSet.signal();
        }finally{
            lock.unlock();
        }
    }

    public T take(){
        lock.lock();
        try{
            while(queue.size() == 0){
                try{
                    emptyWaitSet.await();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            T task = queue.pollFirst();
            fullWaitSet.signal();
            return task;
        }finally{
            lock.unlock();
        }
    }

    public T poll(Long timeOut,TimeUnit timeUnit){
        lock.lock();
        try{
            long timeOutNanos = timeUnit.toNanos(timeOut);
            while(queue.size() == 0){
                if(timeOutNanos <= 0) return null;
                try{
                    timeOutNanos = emptyWaitSet.awaitNanos(timeOutNanos);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            T task = queue.pollFirst();
            fullWaitSet.signal();
            return task;
        }finally{
            lock.unlock();
        }
    }

    public int size(){
        lock.lock();
        try{
            return queue.size();
        }finally{
            lock.unlock();
        }
    }
}



