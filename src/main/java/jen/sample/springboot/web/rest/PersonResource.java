package jen.sample.springboot.web.rest;

import jen.sample.springboot.domain.Person;
import jen.sample.springboot.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonResource {

    private static final Logger logger = LoggerFactory.getLogger(PersonResource.class);
    private PersonService personService;

    @Inject
    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public Person get() {
        Optional<Person> optionalTest = this.personService.create("Fred", 42);
        return optionalTest.orElse(null);
    }
}

