package academy.dev.Concorrencia.test;

import academy.dev.Concorrencia.Dominio.Orcamento;
import academy.dev.Concorrencia.service.StoreServiceWithDiscount;

import java.util.List;

//forma sincrona
public class CompletableFutureTest04 {
    public static void main(String[] args) {
        StoreServiceWithDiscount service = new StoreServiceWithDiscount();
        searchPricesWithDiscount(service);

    }

    private static void searchPricesWithDiscount(StoreServiceWithDiscount service){
        long start = System.currentTimeMillis();
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");
        // stores.forEach(s -> System.out.println(service.getPriceSync(s)));
        stores.stream()
                .map(service::getPriceSync) //store:price:code
                .map(Orcamento::newOrcamento)
                .map(service::applyDesconto)
                .forEach(System.out::println);
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesSync %dms%n", (end - start));
    }
}
