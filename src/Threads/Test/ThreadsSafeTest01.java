package Threads.Test;

import java.util.ArrayList;
import java.util.List;

class ThreadsSafeNames{
    // antes = private final List<String> names = Collections.synchronizedList(new ArrayList<>());
    // voce precisa sincronizar tudo pq não basta notificar que uma parte é uma thread
    // o metodo tbm precisa entrar nessa linha de raciocinio
    private final List<String> names = new ArrayList<>();

    public synchronized void add(String nome){
        names.add(nome);
    }

    public synchronized void removeFirst(){
        if (names.size() > 0){
            System.out.println(Thread.currentThread().getName());
            System.out.println(names.remove(0));
        }
    }
}


public class ThreadsSafeTest01 {
    public static void main(String[] args) {
        // o que significa uma classe thread safe = os metodos que temos para acessar essa classe
        // são metodos sincronizados
        ThreadsSafeNames threadsSafeNames = new ThreadsSafeNames();
        threadsSafeNames.add("Julia");
        Runnable r = threadsSafeNames::removeFirst;
        new Thread(r).start();
        new Thread(r).start();
    }
}
