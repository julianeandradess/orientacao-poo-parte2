package academy.dev.Concorrencia.test;

import academy.dev.Concorrencia.Dominio.Orcamento;
import academy.dev.Concorrencia.service.StoreServiceWithDiscount;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest06 {
    public static void main(String[] args) {
        StoreServiceWithDiscount service = new StoreServiceWithDiscount();
        searchPricesWithDiscountAsync(service);
    }
    private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount service){
        long start = System.currentTimeMillis();
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");

        var completableFutures = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> service.getPriceSync(s)))
                .map(cf -> cf.thenApply(Orcamento::newOrcamento))
                .map(cf -> cf.thenCompose(orcamento -> CompletableFuture.supplyAsync(() -> service.applyDesconto(orcamento))))
                .map(cf -> cf.thenAccept(store -> System.out.printf("%s finish in %d%n",
                        store, (System.currentTimeMillis() - start))))
                .toArray(CompletableFuture[]::new);

        //CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutures);
        CompletableFuture<Object> voidCompletableFuture = CompletableFuture.anyOf(completableFutures);
        voidCompletableFuture.join();
        System.out.printf("Finish? %b%n", voidCompletableFuture.isDone()); //queremos saber se foi finalizado
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesSync %dms%n", (end - start));
    }
    /*
    allOf =
     vai retornar um novo completableFuture, basicamente te indica quando as outras chamadas foram feitas,
     quando fazemos um calculo grande de varios. Ele aceita um array, não lista, logo não usamos o
     collect(toList)

     thenAccept = vai realizar uma ação

     anyOf = vai ser considerado terminado quando uma das tarefas tiver finalizada
     quando um terminada, para
     */
}
