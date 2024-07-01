package academy.dev.junit.service;

import academy.dev.junit.dominio.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
//o nome do metodo, ReturnFalse - o que ele tem que fazer, When - a condição
//podemos usar tbm o @DisplayName("A person should be not adult when age 15 is lower than 18")
//é o que apareceria em vez do nome do metodo.
//parte assertiva, 1° parte: esperado (o que espera?) esperamos que se encontrarmos
//o valor 15, ele seja falso, afinal colocamos um limite de 18
//2°: o que vai gerar/quem vai? nesse caso o personService
//forma inteira:
//Assertions.assertEquals(false, personService.isAdult(person));
//assertFalse(personService.isAdult(person)); simplificada
//para que a gente não crie um objeto toda vez e correr o risco dele ter sido alterado pelos valores que não são fixos
//usamos a anotação: @BeforeEach, que antes de qualquer metodo do teste ser executado
//a exception que foi escolhida no PersonService precisa bater com a que escolhemos por aqui, senão da ruim

class PersonServiceTest {
    private Person adult;
    private Person notAdult;
    private PersonService personService; //como não tem atributo de classe, o new poderia estar aqui que não modifica

    @BeforeEach
    public void setUp(){
        adult = new Person(18);
        notAdult = new Person(15);
        personService = new PersonService();
    }

    @Test
    void isAdult_ReturnFalse_WhenAgeIsLowerThan18() {
        Assertions.assertEquals(false, personService.isAdult(notAdult));
    }

    @Test
    @DisplayName("A person should be adult when age is greater or equals than 18")
    void isAdult_ReturnTrue_WhenAgeIsGreaterOrEqualsThan18() {
        //daria pra usar o mesmo metodo acima, só mudar pra true
        Assertions.assertTrue(personService.isAdult(adult));
    }

    @Test
    @DisplayName("Should throw NullPointerException with message when person is null")
    void isAdult_ThrowException_WhenPersonIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> personService.isAdult(null), "Person can't be null");
    }

    @Test
    @DisplayName("Should return list with only adults")
    void filterRemovingNotAdult_ReturnListWithOnly_WhenListOfPersonWithAdultIsPassef(){
        Person person1 = new Person(17);
        Person person2 = new Person(18);
        Person person3 = new Person(21);
        List<Person> personList = List.of(person1, person2, person3);
        Assertions.assertEquals(2, personService.filterRemovingNotAdult(personList).size()); //eu espero que ao final dessa lista, seja dado uma lista de 2
    }


    /* ANTES DAS MODIFICAÇÕES:
        @Test
        void isAdult_ReturnFalse_WhenAgeIsLowerThan18() {
        Person person = new Person(15);
        PersonService personService = new PersonService();

        Assertions.assertEquals(false, personService.isAdult(person));
    }*/
}