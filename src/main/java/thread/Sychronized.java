package thread;


import java.io.ObjectInputStream;

public class Sychronized {
    private static Object ll = new Object();
    public void printNum(int num) {
        synchronized (ll) {
            System.out.println( Thread.currentThread());
            for (int i =0 ; i < 25; i++) {
                System.out.println(i + " ");
            }
            System.out.println();
        }
    }
//    public static synchronized void printNum(int num) {    //static 类的锁
//        while (true) {
//            System.out.print(Thread.currentThread());
//            for (int i = 0; i < 25; i++) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }

    public synchronized void printNum1(int num) {
        System.out.print(Thread.currentThread());
        for (int i = 25; i > 0; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void printNum2(int num) {
        System.out.print(Thread.currentThread());
        for (int i = 25; i > 0; i--) {
            System.out.print(num);
        }
        System.out.println();
    }

}

class MyThread implements Runnable {
    private Sychronized Sychronized;
    private int num;

    public MyThread(Sychronized Sychronized, int num) {
        this.Sychronized = Sychronized;
        this.num = num;
    }

    public void run() {
        while (true)
        {
            Sychronized.printNum(num);     //执行完释放锁。但由于是死循环 所以一旦进入 就不会退出
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class MyThread1 implements Runnable {
    private Sychronized Sychronized;
    private int num;

    public MyThread1(Sychronized Sychronized, int num) {
        this.Sychronized = Sychronized;
        this.num = num;
    }


    public void run() {
        while (true)
        {
            Sychronized.printNum1(num);     //执行完释放锁
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


class MyThread2 implements Runnable {
    private  Sychronized sychronized;
    private int num;

    public MyThread2(Sychronized sychronized, int num) {
        this.sychronized = sychronized;
        this.num = num;
    }

    public void run() {
        while (true) {
            sychronized.printNum2(num);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class TestSynchronized {

    public static void main(String[] args) {
        Sychronized aa = new Sychronized();
        Sychronized bb = new Sychronized();
        Thread a = new Thread(new MyThread(aa, 1));
        Thread b = new Thread(new MyThread(bb, 2));
//        Thread c = new Thread(new MyThread2(aa, 465));
        a.start();
        b.start();
//        c.start();
    }

}
