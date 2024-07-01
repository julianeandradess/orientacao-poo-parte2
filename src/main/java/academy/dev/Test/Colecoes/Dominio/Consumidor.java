package academy.dev.Test.Colecoes.Dominio;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Consumidor {
    private Long id;
    private String nome;

    //O que podemos fazer para evitar criar um construtor para o id, ter um id autogerado:
    //sem limite de numeração:this.id = ThreadLocalRandom.current().nextLong(origin, bound);
    public Consumidor(String nome) {
        this.id = ThreadLocalRandom.current().nextLong(0, 1000); //mais dificil de ter um valor duplicado
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumidor that = (Consumidor) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Consumidor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }
}
