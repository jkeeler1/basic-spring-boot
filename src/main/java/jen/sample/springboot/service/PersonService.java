package jen.sample.springboot.service;

import jen.sample.springboot.domain.Person;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    public Optional<Person> create(String name, int age) {
        if (name == null || "".equals(name)) {
            return Optional.empty();
        }

        return Optional.of(new Person(name, age));
    }
}

