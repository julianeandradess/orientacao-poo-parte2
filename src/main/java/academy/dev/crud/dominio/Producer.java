package academy.dev.crud.dominio;

import lombok.Builder;
import lombok.Value;


@Value
@Builder

public class Producer {
    Integer id;
    String name;

    /*  quando queremos tornar essa classe imutavel e ter um builder:
        @Value
        @Builder
     */
}
