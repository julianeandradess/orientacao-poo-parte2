package academy.dev.junit.dominio;

import java.util.Objects;

//diferente de uma classe, o record passamos os atributos dentro dele como se fosse um constructor
//para ver o que sua classe tem, mesmo não aparecendo nada aqui, vá em target, arraste o pacote dominio
//ate o terminal, logo dps digite, javap Manga.class, ex.
//o que nao fazer: não podemos criar atributos diretamente, static ate vai. Nada de blocos de iniciação
//bloco static ok, podemos usar generics
//se for usar constructor, tem 2: o canonical e o compact
//canonical: é o constructor que é gerado normal, compact: só vem o nome e o tipo(reduzido)
public record Manga(String name, int episodios) {
    public Manga {
        Objects.requireNonNull(name);
    }
}
