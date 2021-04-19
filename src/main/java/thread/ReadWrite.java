package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWrite {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock;
    private Lock writeLock;
    private int num = -1;

    public ReadWrite() {
        readLock = lock.readLock();
        writeLock = lock.writeLock();
    }

    public void read(){
        while(true){
            try{
                readLock.lock();
                System.out.println(Thread.currentThread()+"准备读取数据!");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread()+"读取的数据为"+num);
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                readLock.unlock();
            }
        }

    }

    public void write(){
        while(true){
            try{
                writeLock.lock();
                System.out.println(Thread.currentThread()+"准备写入数据");
                Thread.sleep(1000);
                num = (int)(Math.random()*10);
                System.out.println(Thread.currentThread()+"已经写入数据"+num);
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                writeLock.unlock();
            }
        }

    }
}

class Main1 {

    public static void main(String[] args) {
        final ReadWrite rd = new ReadWrite();

        for(int i=0;i<3;i++){
            new Thread(new Runnable() {

                @Override
                public void run() {
                    rd.read();
                }
            }).start();;
        }

        new Thread(new Runnable() {

            @Override
            public void run() {
                rd.write();
            }
        }).start();
    }

}