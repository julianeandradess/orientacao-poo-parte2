package academy.dev.Threads.Test;

public class DeaLockeTest01 {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Runnable r1 = () -> {
            synchronized (lock1){
                System.out.println("Thread 1: Segurando lock1 ");
                System.out.println("Thread 1: Esperando lock2 ");
                synchronized (lock2){
                    System.out.println("Thread 1: Segurando lock2 ");
                }
            }
        };
        Runnable r2 = () -> {
            synchronized (lock2){
                System.out.println("Thread 1: Segurando lock2 ");
                System.out.println("Thread 1: Esperando lock1 ");
                synchronized (lock1) {
                    System.out.println("Thread 1: Segurando lock1 ");
                }
            }
        }; //para resolver um dead, seria só inverter a ordem do r2, ficaria: lock1, dps o lock2. Igual ao r1
        new Thread(r1).start();
        new Thread(r2).start();
    }
}
