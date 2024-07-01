package academy.dev.Concorrencia.test;

import academy.dev.Concorrencia.Dominio.Orcamento;
import academy.dev.Concorrencia.service.StoreServiceWithDiscount;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureTest05 {
    public static void main(String[] args) {
        StoreServiceWithDiscount service = new StoreServiceWithDiscount();
        searchPricesWithDiscountAsync(service);
    }
    private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount service){
        long start = System.currentTimeMillis();
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");
        List<CompletableFuture<String>> completableFutures = stores.stream()
                // pegando o preço assincrono storeName:price:desCode
                .map(s -> CompletableFuture.supplyAsync(() -> service.getPriceSync(s)))
                // instanciando o objt newOrcamento para a string gerada por getPriceSync
                .map(cf -> cf.thenApply(Orcamento::newOrcamento))
                //está compondo o primeiro completableFuture, thenCompose - novo estado de completo com o valor que passamos na função
                .map(cf -> cf.thenCompose(orcamento -> CompletableFuture.supplyAsync(() -> service.applyDesconto(orcamento))))
                .collect(Collectors.toList());
        completableFutures.stream().map(CompletableFuture::join).forEach(System.out::println);
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesSync %dms%n", (end - start));
    }
}
