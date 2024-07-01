package academy.dev.crud.dominio;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Anime {
    private Integer id;
    private String nome;
    private int episodios;

    Producer producer;
}
