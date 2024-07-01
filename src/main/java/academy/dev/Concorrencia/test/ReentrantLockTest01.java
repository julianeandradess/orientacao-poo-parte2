package academy.dev.Concorrencia.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable{
    private String name;
    private ReentrantLock lock;

    public Worker(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }
    // o uso do printf, em alguns comandos substitui o uso de %s pelas variaveis que passarei dentro do sout
    // o s representa a variavel, ex: %s, name. A cada %s precisa de uma variavel, %s%s, name, name
    // %d numeros inteiros, %f floa
    // para pular linha porque o, printf não pula, use o %n no final das frases


    /*@Override
    public void run() {
        lock.lock();
        try {
            if (lock.isHeldByCurrentThread()); //usado para saber se o lock está na mao da thread que está executando
            System.out.printf("Thread %s entrou em uma sessão critica%n", name);
            System.out.printf("%d Threads esperando na fila%n", lock.getQueueLength());
            System.out.printf("Threads %d vai esperar 2s", name);
            Thread.sleep(2000);
            System.out.printf("Threads %s finalizou a espera", name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    } outro jeito de usar o lock, para tentar obter o ele por exemplo, mudamos o if de lugar, sem ele
    lançaria uma exception
     */
    @Override
    public void run(){
        try {
            lock.tryLock(2, TimeUnit.SECONDS);
            if (lock.isHeldByCurrentThread()){
                System.out.printf("Thread %s Pegou o LOCK%n", name);

            }
            System.out.printf("%d Threads esperando na fila%n", lock.getQueueLength());
            System.out.printf("Threads %d vai esperar 2s", name);
            Thread.sleep(2000);
            System.out.printf("Threads %s finalizou a espera", name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
                lock.unlock();
            }
    }
}

public class ReentrantLockTest01 {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock(); //colocar o true faz meio que sair de ordem
        new Thread(new Worker("A", lock)).start();
        new Thread(new Worker("B", lock)).start();
        new Thread(new Worker("C", lock)).start();
        new Thread(new Worker("D", lock)).start();
        new Thread(new Worker("E", lock)).start();
        new Thread(new Worker("F", lock)).start();
    }
}
