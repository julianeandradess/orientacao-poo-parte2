package academy.dev.Concorrencia.service;

import academy.dev.Concorrencia.Dominio.Desconto;
import academy.dev.Concorrencia.Dominio.Orcamento;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class StoreServiceWithDiscount {
    public String getPriceSync(String storeName){
        System.out.printf("Getting prices sync for %s%n", storeName);
        double price = priceGenerator();
        Desconto.Code desCode = Desconto.Code.values()[ThreadLocalRandom.current()
                .nextInt(Desconto.Code.values().length)];
        return String.format("%s:%.2f:%s", storeName, price, desCode);
    }

    public String applyDesconto(Orcamento orcamento){
        delay();
        double descontoValor = orcamento.getPreco() * (100 - orcamento.getDesCode().getPorcentagem()) / 100;
        return String.format("'%s' original price: '%.2f'. Applying Desconto code: '%s'. Final price: '%.2f'",
                orcamento.getStore(),
                orcamento.getPreco(),
                orcamento.getDesCode(),
                descontoValor);
    }

    private double priceGenerator(){ //String storeName
        delay();
        return ThreadLocalRandom.current().nextInt(1,500)* 10;
    }

    private void delay() {
        try {
            int milli = ThreadLocalRandom.current().nextInt(200, 2500);
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}