package academy.dev.Threads.Dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Membros {
    //vamos mandar os emails na mesma ordem usamos o queue
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private  boolean open = true;

    //peding vai retornar o size, se ainda temos algum email esperando para ser enviado
    public boolean isOpen(){
        return open;
    }
    public int pedingEmails(){
        synchronized (emails){
            return emails.size();
        }
    }

    public void addMemberEmails(String email){
        synchronized (this.emails){
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " Adicionou email na lista");
            this.emails.add(email);
            //TODO voltar quando a thread estiver esperando. - resolvido
            this.emails.notifyAll(); //notifica todas as threads
        }
    }

    //senão tiver emails, não queremos que o metodo pare, queremos que a thread fique esperando
    //quando for usar o wait, trate a sessão, InterruptedEx
    //todas as vezes que for chamar o wait, é obrigatorio que esteja dentro do bloco synchronized
    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " checking if there are email");
        synchronized (this.emails){
            while (this.emails.size() == 0){
                if(!open) return null;
                System.out.println(Thread.currentThread().getName() + " Não tem email disponivel na lista, entrando em modo de espera.");
                this.emails.wait();
            }
            return this.emails.poll(); // retorna e retira
        }
    }

    public void close(){
        open = false;
        synchronized (this.emails) {
            System.out.println(Thread.currentThread().getName() + " Notificando todos que não estamos mais pegando emails");
            this.emails.notifyAll();
        }
    }
}
