package academy.dev.Concorrencia.test;

import academy.dev.Concorrencia.service.StoreService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureTest02 {
    public static void main(String[] args) {
        StoreService storeService = new StoreService();
        searchPriceAsyncCompletableFuture(storeService);
    }
    private static void searchPriceAsyncCompletableFuture(StoreService storeService){

        //se for fazer a variavel sem ajeitar o collect primeiro, dará isso: List<CompletableFuture<Double>> collect =
        //precisaremos quebrar o stream antes de rodar senão o resultado ficará sempre como sincrona


        long start = System.currentTimeMillis();
        List<String> stores = List.of("Story 1", "Story 2", "Story 3", "Story 4");
        List<CompletableFuture<Double>> completableFutures = stores.stream()
                .map(storeService::getPricesAsyncCompletableFuture)
                .collect(Collectors.toList());
        List<Double> prices = completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());

        System.out.println(prices);
        long end = System.currentTimeMillis();
        System.out.printf("Time passsed to searchPricesSysd %dms%n", (end-start));

    }
}
