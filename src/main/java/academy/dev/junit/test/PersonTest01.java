package academy.dev.junit.test;

import academy.dev.junit.dominio.Person;
import academy.dev.junit.service.PersonService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PersonTest01 {
    public static void main(String[] args) {
        Person person = new Person(15);
        PersonService personService = new PersonService();
        log.info("Is adult? '{}' ", personService.isAdult(person));
    }
}
