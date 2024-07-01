package academy.dev.Threads.Dominio;

public class Account {
    private int balance = 50;


    public void saque(int amount){
        this.balance = this.balance - amount;
    }
    public int getBalance() {
        return balance;
    }
}
