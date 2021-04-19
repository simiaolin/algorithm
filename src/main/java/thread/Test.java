package thread;

public class Test {
    public static int num = 1000000;

    public static void main(String[] args) {
        Thread[] threads = getThreadsForReentrantLock();
        Thread a = threads[0];
        Thread b = threads[1];

        a.start();
        b.start();

        /*
         * 主线程等待子线程完成，然后再打印数值
         */
        try {
            a.join();
            b.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(num);

    }

    public static Thread[]  geThreadsFortestRaceCondition() {
        Thread a = new Thread(new RaceCondition(1));
        Thread b = new Thread(new RaceCondition(2));
        return new Thread[] {a,  b};
    }

    public static Thread[] getThreadsForReentrantLock() {
        Thread a = new Thread(new UseReentrantLock(1));
        Thread b = new Thread(new UseReentrantLock(2));
        return new Thread[] {a,  b};
    }



}
