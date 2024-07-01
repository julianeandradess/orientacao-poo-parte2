package academy.dev.Concorrencia.test;

import academy.dev.Concorrencia.service.StoreService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFutureTest01 {
    public static void main(String[] args) {
        StoreService storeServece =  new StoreService();
        //searchPriceSyn(storeServece);
        //searchPriceAsyncFuture(storeServece);
        searchPriceAsyncCompletableFuture(storeServece);
    }


    private static void searchPriceSyn(StoreService storeService){
        long start = System.currentTimeMillis();
        System.out.println(storeService.getPriceSyn("Store 1"));
        System.out.println(storeService.getPriceSyn("Store 2"));
        System.out.println(storeService.getPriceSyn("Store 3"));
        System.out.println(storeService.getPriceSyn("Store 4"));
        long end = System.currentTimeMillis();
        System.out.printf("Time passsed to searchPricesSysd %dms%n", (end-start));
        StoreService.shutdown();
    }

    //forma assincrona, com a estrutura dentro do try, vai uma por uma e não seguida, fora do try assim, funciona no coletivo
    private static void searchPriceAsyncFuture(StoreService storeService){
        long start = System.currentTimeMillis();
        Future<Double> pricesAsyncFuture1 = storeService.getPricesAsyncFuture("Store 1");
        Future<Double> pricesAsyncFuture2 = storeService.getPricesAsyncFuture("Store 2");
        Future<Double> pricesAsyncFuture3 = storeService.getPricesAsyncFuture("Store 3");
        Future<Double> pricesAsyncFuture4 = storeService.getPricesAsyncFuture("Store 4");
        try {
            System.out.println(pricesAsyncFuture1.get());
            System.out.println(pricesAsyncFuture2.get());
            System.out.println(pricesAsyncFuture3.get());
            System.out.println(pricesAsyncFuture4.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.printf("Time passsed to searchPricesSysd %dms%n", (end-start));
        StoreService.shutdown();
    }

    //vantagem do Completable nesse caso é que não precisa do executor e shutdown como os outros,
    //não lança exception tbm, podendo assim usar o join com tranquilidade

    private static void searchPriceAsyncCompletableFuture(StoreService storeService){
        long start = System.currentTimeMillis();
        CompletableFuture<Double> pricesAsyncComFuture1 = storeService.getPricesAsyncCompletableFuture("Store 1");
        CompletableFuture<Double> pricesAsyncComFuture2 = storeService.getPricesAsyncCompletableFuture("Store 2");
        CompletableFuture<Double> pricesAsyncComFuture3 = storeService.getPricesAsyncCompletableFuture("Store 3");
        CompletableFuture<Double> pricesAsyncComFuture4 = storeService.getPricesAsyncCompletableFuture("Store 4");
            System.out.println(pricesAsyncComFuture1.join());
            System.out.println(pricesAsyncComFuture2.join());
            System.out.println(pricesAsyncComFuture3.join());
            System.out.println(pricesAsyncComFuture4.join());
        long end = System.currentTimeMillis();
        System.out.printf("Time passsed to searchPricesSysd %dms%n", (end-start));

    }
}
