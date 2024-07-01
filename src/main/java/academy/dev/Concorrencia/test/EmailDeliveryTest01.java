package academy.dev.Concorrencia.test;


import academy.dev.Concorrencia.Dominio.Membros;
import academy.dev.Concorrencia.service.EmailDeliveryService;

import javax.swing.*;

public class EmailDeliveryTest01 {
    public static void main(String[] args) {
        Membros membros = new Membros();
        Thread gege = new Thread(new EmailDeliveryService(membros), "Gege");
        Thread kaka = new Thread(new EmailDeliveryService(membros), "Kaka");

        gege.start();
        kaka.start();

        while (true){
            String email = JOptionPane.showInputDialog("Entre com o seu email");
            if (email == null || email.isEmpty()){
                membros.close();
                break;
            }
            membros.addMemberEmails(email);
        }
    }
}
