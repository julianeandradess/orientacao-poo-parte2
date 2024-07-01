package academy.dev.Test.Colecoes.Dominio;

import java.util.Objects;

public class Manga implements Comparable<Manga>{
    //quando lançamos o Comparable<> automaticamente precisamos do CompareTo, não se esqueça
    //Comparator- O uso é análago ao da interface(Comparable), mas não compromete uma classe com nenhuma função
    //de comparação especial. Como a classe "Pessoa" só pode implementar Comparable uma vez
    //Já o Comparator permite que você crie regras extras de comparação para as classes que você possui.
    private Long id;
    private String nome;
    private double preco;
    private int quantidade;

    public Manga(Long id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
    //construtor sobrecarregado

    public Manga(Long id, String nome, double preco, int quantidade) {
        this(id,nome,preco);
        this.quantidade = quantidade;
    }


    //quando trabalhamos com coleção precisamos estar preparados para fazer as buscas


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return Objects.equals(id, manga.id) && Objects.equals(nome, manga.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    //dentro do compareTo podemos usar o this ou o objeto que está ao lado do Manga(variavel de referencia)
    //não da para usar tipos primitivos no compareTo diretamente
    //regras:
    //retorna negativo se o this for menor < que o outroManga
    //se this for == outroManga, retorna 0zero
    //retorna positivo se o this for > maior que o outroManga
    //basicamente um exemplo claro:


    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int compareTo(Manga outroManga) {
       /* if (this.id < outroManga.getId()){
            return -1;
        }else if (this.id.equals(outroManga.getId())){
            return 0;
        }else {
            return 1;
        }*/
        //maneira mais facil:
        //return  this.id.compareTo(outroManga.getId());

        //organizar por preço:
        //return Double.valueOf(preco).compareTo(outroManga.getPreco()); ou alt+ent return Double.compare(preco, outroManga.getPreco());

        //organizar por nome, alfabetica:
        return this.nome.compareTo(outroManga.getNome());
    }
}
