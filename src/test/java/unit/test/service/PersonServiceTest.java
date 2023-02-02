package unit.test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import unit.test.data.Person;
import unit.test.repository.PersonRepository;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp(){
        personService = new PersonService(personRepository);
    }

    @Test
    void testGetPersonNotFound(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> personService.get("not found"));
    }

    @Test
    void testGetPersonSuccess(){
        // menambah behaviour ke mock object
        Mockito.when(personRepository.selectById("nursalim")).thenReturn(new Person("nursalim", "Nursalim"));

        var person = personService.get("nursalim");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("nursalim", person.getId());
        Assertions.assertEquals("Nursalim", person.getName());
    }

    @Test
    void testRegisterSuccess(){
        var person = personService.register("Nursalim");

        Mockito.verify(personRepository, Mockito.times(1)).insert(new Person(person.getId(), "Nursalim"));

        Assertions.assertNotNull(person);
        Assertions.assertEquals("Nursalim", person.getName());
        Assertions.assertNotNull(person.getId());


    }

}
