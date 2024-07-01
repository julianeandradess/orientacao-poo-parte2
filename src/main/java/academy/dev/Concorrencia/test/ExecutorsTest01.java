package academy.dev.Concorrencia.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Printer implements Runnable{
    private final int num;

    Printer(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.printf("%s inicio: %s%n", Thread.currentThread().getName(), num);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s finalizou: %s%n", Thread.currentThread().getName());

    }
}
public class ExecutorsTest01 {
    public static void main(String[] args) {
        //System.out.println(Runtime.getRuntime().availableProcessors());
        //analisa quantos processodores tem, tbm diz quantas threads pode rodar ao mesmo tempo, tecnicamente
        //é como se trocassemos o start, botamos pra executar
        //newFixedThread = vai criar um pool de thread fixo

        //ExecutorService executorService = Executors.newFixedThreadPool(2);
        //executorService.execute(new Printer(1));
        //executorService.execute(new Printer(2));
        //executorService.shutdown(); //parar o executor, no momento que ele executar vai desligar
        //while (!executorService.isTerminated()){} //enquanto o executor não for terminado, segure
        //System.out.println("Programa foi finalizado");

        System.out.println("--------");

        //ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        //cria apenas uma thread, não precisa dar start, fica responsavel por todas as tarefas

        System.out.println("---");
        ExecutorService executorService3 = Executors.newCachedThreadPool();
        executorService3.execute(new Printer(1));
        //basicamente cria thread conforme vai precisando mas vai reutilizar quando tiver disponivel

    }
}
