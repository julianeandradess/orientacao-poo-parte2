package Threads.Test;

import Threads.Dominio.Account;

// poderiamos implementar a Runnable ou chamar ela na main diretamente
public class ThreadAccountTest01 implements Runnable{
    private Account account = new Account();

    public static void main(String[] args) {
        // vamos supor que temos 2 threads que vão acessar o mesmo objeto, vai dar merda
        //sincronismo de threads
        ThreadAccountTest01 threadAccountTest01 = new ThreadAccountTest01();
        Thread t1 = new Thread(threadAccountTest01, "Hestia");
        Thread t2 = new Thread(threadAccountTest01, "Cranel");

        t1.start();
        t2.start();

    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            saque(10);
            if (account.getBalance() < 0){
                System.out.println("agora pronto '-' ");
            }
        }
    }
    private void saque(int amount){
        if (account.getBalance() >= amount){
            System.out.println(getThreadName() + " está indo sacar dinheiro");
            account.saque(amount);
            System.out.println(getThreadName() + " completou o saque, valor atual na conta " + account.getBalance());
        }else {
            System.out.println("Sem dinheiro para " + getThreadName() + " efetuar o saque " + account.getBalance());
        }
    }

    private String getThreadName(){
        return Thread.currentThread().getName();
    }

}
