package jen.sample.springboot.service;

import jen.sample.springboot.domain.Person;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class PersonServiceTest {

    @Autowired private PersonService personService;

    @Test
    public void createHappyPath() {
        Optional<Person> optionalPerson = this.personService.create("Fred", 1);
        Person person = optionalPerson.get();
        assertThat("valid name", person.getName(), equalTo("Fred"));
    }

    @Test
    public void sadPath() {
        Optional<Person> optionalPerson = this.personService.create(null, 1);
        assertThat("name was null", optionalPerson.isPresent(), is(false));
    }

    @Test
    public void anotherSadPath() {
        Optional<Person> optionalPerson = this.personService.create("", 1);
        assertThat("name was blank", optionalPerson.isPresent(), is(false));
    }
}

