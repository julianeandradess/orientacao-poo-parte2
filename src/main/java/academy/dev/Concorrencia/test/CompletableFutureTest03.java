package academy.dev.Concorrencia.test;

import academy.dev.Concorrencia.service.StoreServiceDeprecated;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

//vamos supor que não temos acesso ao metodo getPricesAsyncFuture e so temos acesso ao getPricesSyn
//porem queremos de forma assincrona, apesar dele se apresentar de forma sincrona
//apesar do supplay ser sobrecarregado, ele aceita um executor
public class CompletableFutureTest03 {
    public static void main(String[] args) {
        StoreServiceDeprecated storeServiceDeprecated = new StoreServiceDeprecated();
        searchPriceAsyncCompletableFuture(storeServiceDeprecated);
    }
    private static void searchPriceAsyncCompletableFuture(StoreServiceDeprecated storeServiceDeprecated){

        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(5, r ->{
            Thread thread = new Thread(r); //troca o comportamento das threads criadas, tira o pool do nome tbm
            thread.setDaemon(true);
            return thread;
        });
        List<String> stores = List.of("Story 1", "Story 2", "Story 3", "Story 4");
        List<CompletableFuture<Double>> completableFutureStream = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> storeServiceDeprecated.getPriceSyn(s), executorService))
                .collect(Collectors.toList());
        List<Double> prices = completableFutureStream.stream().map(CompletableFuture::join).collect(Collectors.toList());


        System.out.println(prices);
        long end = System.currentTimeMillis();
        executorService.shutdown();
        System.out.printf("Time passsed to searchPricesSysd %dms%n", (end-start));

    }
}
