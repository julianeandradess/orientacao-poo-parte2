package academy.dev.Concorrencia.Dominio;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Membros {
    //vamos mandar os emails na mesma ordem usamos o queue
    //para usar o wait, notfiAll com o lock, precisamos de uma classe que é a condition
    //para usar a condition usamos a variavel do Lock/ReentrantLock, essa condição suporta o wait, notify..
    private final ReentrantLock lock = new ReentrantLock();
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private final Condition condition = lock.newCondition();
    private  boolean open = true;



    public boolean isOpen(){
        return open;
    }

    public int pedingEmails(){
        lock.lock();
        try {
            return emails.size();
        }finally {
            lock.unlock();
        }
    }

    public void addMemberEmails(String email){
        lock.lock();
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " Adicionou email na lista");
            this.emails.add(email);
            condition.signalAll();// antes: this.emails.notifyAll(); notifica todas as threads
        }finally {
            lock.unlock();
        }

    }

    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " checking if there are email");
        try {
            while (this.emails.size() == 0){
                if(!open) return null;
                System.out.println(Thread.currentThread().getName() + " Não tem email disponivel na lista, entrando em modo de espera.");
                condition.await();//antes: this.emails.wait();
            }
            return this.emails.poll(); // retorna e retira
        }finally {
            lock.unlock();
        }
    }

    public void close(){
        open = false;
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Notificando todos que não estamos mais pegando emails");

        }finally {
            lock.unlock();
        }
    }
}
