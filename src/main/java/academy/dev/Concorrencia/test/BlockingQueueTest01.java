package academy.dev.Concorrencia.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest01 {
    public static void main(String[] args) throws InterruptedException {
        //BlockingQueue = é uma classe especial onde tem um limite de valores pra voce botar la dentro
        //se tentarmos colocar algo alem da capacidade, ele bloqueia a thread enquanto não trocar
        //o peek retorna o valor sem remover ele daquela lista
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        bq.put("will");
        System.out.printf("%s added the value %s%n", Thread.currentThread().getName(), bq.peek());
        System.out.println("Tryving to add another value");
        new Thread(new RemoveFromQueue(bq)).start();
        bq.put("laura");
        System.out.printf("%s added the value %s%n", Thread.currentThread().getName(), bq.peek());

    }

    static class RemoveFromQueue implements Runnable{
        private final BlockingQueue<String> bq;

        RemoveFromQueue(BlockingQueue<String> bq) {
            this.bq = bq;
        }

        //para remover usamos o take
        @Override
        public void run() {
            System.out.printf("%s going to sleep for 2s %n", Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.printf("%s removing value from queue %s%n", Thread.currentThread().getName(), bq.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
