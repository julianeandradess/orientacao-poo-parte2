package academy.dev.Concorrencia.Dominio;

import static academy.dev.Concorrencia.Dominio.Desconto.*;

public final class Orcamento {
    private final String store;
    private final Double preco;
    private final Code DesCode;

    public Orcamento(String store, double preco, Code desCode) {
        this.store = store;
        this.preco = preco;
        DesCode = desCode;
    }

    public String getStore() {
        return store;
    }

    public Double getPreco() {
        return preco;
    }

    public Code getDesCode() {
        return DesCode;
    }

    @Override
    public String toString() {
        return "Orcamento{" +
                "store='" + store + '\'' +
                ", preco=" + preco +
                ", DesCode=" + DesCode +
                '}';
    }

    /**
     * Creates new Orcamento object from the value following the pattern storeName:price:Desconto
     * @param value the containing storeName:price:Desconto
     * @return new Orcamento from with values from @param value
     */
    public static Orcamento newOrcamento (String value){
        String[] values = value.split(":");
        double preco = Double.parseDouble(values[1].replace(",", "."));
        return new Orcamento(values[0], preco, Desconto.Code.valueOf(values[2]));
    }

}
