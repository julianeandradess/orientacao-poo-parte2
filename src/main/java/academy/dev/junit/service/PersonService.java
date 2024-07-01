package academy.dev.junit.service;

import academy.dev.junit.dominio.Person;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

//o teste sempre é melhor feito na camada de negocio, alt + enter e voce poe o teste jUnit pra rodar
public class PersonService {
    public boolean isAdult(Person person){
        //usamos assim antes de lançar a exception abaixo: Objects.requireNonNull(person, "Person can't");
        if (person == null){
            throw new IllegalArgumentException();
        }
        return person.getIdade() >= 18; //como existe a possibilidade de ser null
    }

    //remover todos que não são adultos, para filtrar
    public List<Person> filterRemovingNotAdult(List<Person> personList){
        return personList.stream().filter(this::isAdult).collect(Collectors.toList());
    }
}
