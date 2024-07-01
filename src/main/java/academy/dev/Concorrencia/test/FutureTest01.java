package academy.dev.Concorrencia.test;

import java.util.concurrent.*;

public class FutureTest01 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // exemplo de uma cotação de dolar e queremos saber o resultado, essa é a thread que vai fazer
        // a execução, essa thread main vai simular como se estivesse indo no servidor remoto pegar a cotação
        // para a lambda abaixo: submit(new Callable<Double>... dps alt+enter
        // quando trabalhamos com Executors precisamos do shutdown, não esqueça
        // quando requisição assincrona geralmente definimos um prazo maximo para que ela responda, para lançarmos uma exception
        // dollarRequest.get = se torna um metodo super sobrecarregado
        Future<Double> dollarResquest = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(5);
            return 4.35D;
        });

        System.out.println(doSomenthing());
        Double dollarResponse = null;//chamar a cotação do dolar e botar tempo maximo pra lançar exception
        try {
            dollarResponse = dollarResquest.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }finally {
            executorService.shutdown();
        }
        System.out.println("Dollar: "+dollarResponse);
    }
    //vamos simular como se tivesse fazendo outra coisa
    private static long doSomenthing(){
        System.out.println(Thread.currentThread().getName());
        long sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
        return sum;
    }
}
