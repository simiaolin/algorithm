package thread;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerAndConsumer {

    public static void main(String[] args) {
        //大小为10的循环数组阻塞队列
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        /*
         * 用5个生产者线程来生产产品
         */
        for(int i=0;i<5;i++){
            new Thread(new ProductThread(queue)).start();
        }

        /*
         * 用2个消费者线程来消费产品
         */
        for(int i=0;i<2;i++){
            new Thread(new ConsumeThread(queue)).start();
        }
    }

}


 class ProductThread implements Runnable {

    private ArrayBlockingQueue<Integer> queue;

    public ProductThread(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run(){
        while(true){
            try {
                int product = (int)(Math.random()*10);
                /*
                 * 队列满时会阻塞
                 */
                queue.put(product);
                System.out.println(Thread.currentThread()+"生产了产品——"+product+" 剩余元素："+queue.size());
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}


class ConsumeThread implements Runnable {

    private ArrayBlockingQueue<Integer> queue;

    public ConsumeThread(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run(){
        while(true){
            try {
                /*
                 * 队列空时会阻塞
                 */
                int product = queue.take();
                System.out.println(Thread.currentThread()+"消费了元素——"+product+" 剩余空间："+queue.size());
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}