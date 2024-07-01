package academy.dev.Concorrencia.service;

import java.util.concurrent.*;

public class StoreService {
    //pegar os preços de forma sincrona
    private static final ExecutorService ex = Executors.newCachedThreadPool(); //cria a vontade

    public double getPriceSyn(String storeName){
        System.out.printf("Getting prices sync for store %s%n", storeName);
        return priceGenerator();
    }

    public Future<Double> getPricesAsyncFuture(String storeName){
        System.out.printf("Getting prices sync for store %s%n", storeName);
        Future<Double> submit = ex.submit(this::priceGenerator);
        return submit;//(() -> Double.valueOf(storeName));
    }

    //não faz o uso do executor, shutdown
    public CompletableFuture<Double> getPricesAsyncCompletableFuture(String storeName){
        System.out.printf("Getting prices sync for store %s%n", storeName);
        return CompletableFuture.supplyAsync(this::priceGenerator);
    }


    public static void shutdown(){
        ex.shutdown();
    }

    private double priceGenerator(){ //String storeName
        System.out.printf("%s generating price %n", Thread.currentThread().getName());
        delay();
        return ThreadLocalRandom.current().nextInt(1,500)* 10;
    }

    private void delay() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}