package academy.dev.Concorrencia.test;


import java.util.concurrent.*;

class RandomNumberCallable implements Callable<String> {
//é passado <> o tipo de retorno que queremos
//math.random = pegar numero aleatorio, é sincronizado, precisa de mts locks
//ThreadsLocalRandom = gera numero aleatorio tbm, quando tiver trabalhando com multiplas threads é melhor
    @Override
    public String call() throws Exception {
        //Math.random();
        int count = ThreadLocalRandom.current().nextInt(1, 11);
        for (int i = 0; i < count ; i++){
            System.out.printf("%s executando uma tarefa callable...%n", Thread.currentThread().getName());
        }
        return String.format("%s finashed and the random number is %d", Thread.currentThread().getName(), count);
    }
}
//Quando tiver trabalhando com executor ou threads pool, evite usar o notify

public class CallableTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RandomNumberCallable randomNumberCallable = new RandomNumberCallable();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(randomNumberCallable); //significa que a resposta vai vir no futuro
        String s = future.get();
        System.out.printf("%s Program finished %s", Thread.currentThread().getName(), s);
        executorService.shutdown();
    }
}
