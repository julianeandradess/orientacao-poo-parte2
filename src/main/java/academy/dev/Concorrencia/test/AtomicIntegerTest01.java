package academy.dev.Concorrencia.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// "jeito errado":
// se usarmos synchronized, ele pesará pq só pode acessar uma thread por vez
// o atomic é usado para contagem de forma atomica, tendo certeza de que não serão alterados
// diferença entre o synchronized e o lock/reentrantlock é que você tem o controle
// vantagem: o construtor tem o conceito de "fair" que podemos lançar true ou false
// a parte ruim que temos que usar manualmente, fica "feio"
class Counter{
    private int count;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private Lock lock = new ReentrantLock(true);

    void increment(){
        lock.lock();
        try {
            count++;
            atomicInteger.incrementAndGet();
        }finally {
            lock.unlock();
        }
        count++;
        atomicInteger.incrementAndGet();
    }

    public int getCount() {
        return count;
    }
    public AtomicInteger getAtomicInteger(){
        return atomicInteger;
    }
}
public class AtomicIntegerTest01{
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable r = () -> {
            for (int i = 0; i < 2000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(" Rodando "+counter.getCount());
        System.out.println(" Rodando 2"+counter.getAtomicInteger());
    }
}
