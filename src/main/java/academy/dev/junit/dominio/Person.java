package academy.dev.junit.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;

//@data = get e set criados com data
//allConstructor = irá adicionar todos atributos que precisamos
@Data
@AllArgsConstructor
public class Person {
    private int idade;
}
