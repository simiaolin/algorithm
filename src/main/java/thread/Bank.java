package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bank  {/**
 * 利用数组模拟银行账户
 */
private final double accounts[];
        private ReentrantLock lock = new ReentrantLock();
        private Condition condition;
        public Bank() {
            accounts = new double[10];
            /*
             * 初始化，使每个账户都初始有initialBalance金钱
             */
            for (int i = 0; i < 10; i++)
                accounts[i] = 1000;
            condition = lock.newCondition();
        }

        /**
         * 资金转移的方法
         *
         * @param from
         *            源账户
         * @param to
         *            目标账户
         * @param amount
         *            转移金额
         */
        public void transfer(int from, int to, double amount) {
            lock.lock();
            try {
                if (accounts[from] < amount)
                    condition.await();
                System.out.print(Thread.currentThread());
                accounts[from] -= amount;
                System.out.printf("%5.2f from %d to %d", amount, from, to);
                accounts[to] += amount;
                System.out.printf(" Total Balance:%5.2f\n", getTotalBalance());
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        /**
         * 获取所有账户的总金额
         *
         * @return
         */
        public double getTotalBalance() {
            lock.lock();
            double sum = 0;
            try {
                for (double a : accounts)
                    sum += a;
            } finally {
                lock.unlock();
            }
            return sum;
        }

        /**
         * 获取现在账户的数量
         *
         * @return
         */
        public int size() {
            return accounts.length;
        }
}

 class TransferRunnable implements Runnable{

    private Bank bank;
    private int fromAccount;

    public TransferRunnable(Bank b,int from){
        bank=b;
        fromAccount=from;
    }

    public void run(){
        try{
            while(true)
            {
                int toAccount = (int)(bank.size()*Math.random());
                double amount = 1000*Math.random();
                bank.transfer(fromAccount, toAccount, amount);
                Thread.sleep(1000);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class Main {

    public static void main(String[] args) {
        Bank b = new Bank();
        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(new TransferRunnable(b, i));
        }

        for(int i=0;i<10;i++){
            threadArray[i].start();
        }
    }

}
