package academy.dev.Threads.Test;


/* o que é a Thread = pode ser um objeto porque temos ate uma classe e pode ser um processo, linha de execução
temos 2 tipos de threads, a daemon(não tem tanta prioridade, é a que toma conta
user(é a que java usa para encerrar, são terminadas)
criando uma thread: podemos extender a classe thread
dá para sobrecarregar-las dando nome, tipo ('A', T1)
Estados da Thread = new, Runnable, Running, Waiting/blocked e Dead
explicação: new = criada, runnable = start(pronta pra mudar de estado), running = executando
waiting/blocked = esperando a vez dela ou bloqueada, dead = morta, dps de morta só criando um objeto novo, não dá pra reutilizar
As prioridades vão de 1-10, usando o metodo ex: t3.setPriority();
Usamos o sleep, geralmente para dar uma pausa no looping para que o codigo consulte uma api por ex
*/

class ThreadExemples extends Thread{
    private final char c;
    public ThreadExemples(char c){
        this.c = c;
    }

    //ctrl+o para o metodo run, precisa rescreve-lo
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            System.out.print(c);
            if (i % 50 == 0){
                System.out.println();
            }
        }
    }
}
class ThreadExempleRunnable implements Runnable{
    private final char d;
    public ThreadExempleRunnable(char d){
        this.d = d;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
             System.out.print(d);
            if (i % 50 == 0){
                System.out.println();
            }
            try {
                Thread.sleep(2000); //poucos metodos garantidos na thread, temos que trata-la pq está sobrecarregando
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ThreadsTest01 {
    public static void main(String[] args) {
        /* não é pelo main no começo é pela thread que executa o programa
        threadExemple1.run(); se fizesse assim, iria reproduzir uma thread por vez, já o start é aleatorio
        ThreadExemple threadExemple1 = new ThreadExemple('A');
        ThreadExemple threadExemple2 = new ThreadExemple('B');
        ThreadExemple threadExemple3 = new ThreadExemple('C');
        ThreadExemple threadExemple4 = new ThreadExemple('D');
        threadExemple1.start();
        threadExemple2.start();
        threadExemple3.start();
        threadExemple4.start();*/

        //são diferentes porque uma voce implenta e na outra extends, uma te força a lembrar do metodo run e a iniciação tbn é diferente
        //porem vão atingir o mesmo objetivo, sem muita ordem.
        //não podemos dar start 2x na mesma thread, ex: t1.start(); t1.start(); dará excessão
        //a thread main, que é a principal, nunca entrará no metodo run, porque para isso teriamos que chamar t1.run
        Thread t1 = new Thread(new ThreadExempleRunnable('A'),"T1A");
        Thread t2 = new Thread(new ThreadExempleRunnable('B'), "T2B");
        Thread t3 = new Thread(new ThreadExempleRunnable('C'), "T3C");
        Thread t4 = new Thread(new ThreadExempleRunnable('D'), "T4D");

        t4.setPriority(Thread.MAX_PRIORITY); //não é garantida prioridade porem estamos sinalizando, não se baseie nele
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

