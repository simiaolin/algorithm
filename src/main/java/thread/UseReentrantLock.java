package thread;

import java.util.concurrent.locks.ReentrantLock;

public class UseReentrantLock implements Runnable {
    /**
     * 计算类型，1表示减法，其他的表示加法
     */
    private int type;
    /**
     * 锁对象
     */
    private static ReentrantLock lock = new ReentrantLock();  //static 多个线程共用一个锁

    public UseReentrantLock(int type) {
        this.type = type;
    }

    public void run() {

        if (type == 1)
            for (int i = 0; i < 10000; i++) {

                lock.lock();
                try {

                    Test.num--;
                } finally {
                    lock.unlock();

                }


            }
        else
            for (int i = 0; i < 10000; i++) {

                lock.lock();

                try {

                    Test.num++;
                } finally {

                    lock.unlock();
                }
            }

    }
}
