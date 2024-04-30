package Threads.Test;

import Threads.Dominio.Account;


public class ThreadAccountTest02 implements Runnable{
    private final Account account = new Account();

    public static void main(String[] args) {
        // parte 2: como resolver o sincronismo, enquanto uma thread não terminar o método dela
        // a outra não poderá entrar pois senão conflita, uma tirará o valor que seria correspondente a outra
        // quando usamos o metodo synchronized no saque, não vai existir paralelismo
        //esse metodo pode ser usado tanto no metodo normal ou então no bloco, e tbm nos static

        ThreadAccountTest02 threadAccountTest01 = new ThreadAccountTest02();
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
    //no metodo:
    /*private synchronized void saque(int amount){
        if (account.getBalance() >= amount){
            System.out.println(getThreadName() + " está indo sacar dinheiro");
            account.saque(amount);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(getThreadName() + " completou o saque, valor atual na conta " + account.getBalance());
            }
        }else {
            System.out.println("Sem dinheiro para " + getThreadName() + " efetuar o saque " + account.getBalance());
        }
    }*/
    // quando usamos o synchronized dentro do bloco, precisamos deixar esse objto como final pois significa
    // que em algum momento se voce quiser pegar o account ele não está modificado
    private void saque(int amount){
        System.out.println(" ---- fora do synchronized ---- ");
        synchronized (account) {
            System.out.println(getThreadName() + " dentro do synchronized");
            if (account.getBalance() >= amount) {
                System.out.println(getThreadName() + " está indo sacar dinheiro");
                account.saque(amount);
            } else {
                System.out.println("Sem dinheiro para " + getThreadName() + " efetuar o saque " + account.getBalance());
            }
        }
    }

    private static synchronized void print() {
        // ou synchronized(ThreadAccountTest01.class){ }
    }
    private String getThreadName(){
        return Thread.currentThread().getName();
    }

}
