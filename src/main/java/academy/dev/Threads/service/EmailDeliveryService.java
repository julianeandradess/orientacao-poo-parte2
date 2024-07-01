package academy.dev.Threads.service;

import academy.dev.Threads.Dominio.Membros;

public class EmailDeliveryService implements Runnable{
    private final Membros membros;

    public EmailDeliveryService(Membros membros) {
        this.membros = membros;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " starting to deliver emails...");
        while (membros.isOpen() || membros.pedingEmails() > 0){
            try {
                String email = membros.retrieveEmail();
                if (email == null) continue;
                System.out.println(threadName + " enviando email para " + email);
                Thread.sleep(2000);
                System.out.println(threadName + " enviou email com sucesso para "+ email);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Todos os emails foram enviados com sucesso.");
    }
}
