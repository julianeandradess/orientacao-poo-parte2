package Streams.Dominio;

import java.util.Objects;

public class LightNovel {
    private String nome;
    private double price;
    private Category category;

    public LightNovel(String nome, double price) {
        this.nome = nome;
        this.price = price;
    }

    public LightNovel(String nome, double price, Category category) {
        this.nome = nome;
        this.price = price;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LightNovel that = (LightNovel) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    public String getNome() {
        return nome;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "LightNovel{" +
                "nome='" + nome + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }

}
