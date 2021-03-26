package jen.sample.springboot.controller;

import jen.sample.springboot.domain.Person;
import jen.sample.springboot.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Optional;

@Controller
@RequestMapping("/person-page")
public class PersonController {

    private PersonService personService;

    @Inject
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String clientLauncherPage(Model model) {
        Optional<Person> optionalPerson = this.personService.create("mona", 12);
        model.addAttribute("person", optionalPerson.get());
        return "person-output";
    }
}

