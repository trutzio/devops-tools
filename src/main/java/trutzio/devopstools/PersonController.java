package trutzio.devopstools;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.opentelemetry.instrumentation.annotations.WithSpan;

@RestController
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    @WithSpan("test span")
    public String newPerson() throws InterruptedException {
        Person person = new Person();
        person.name = "John Doe";
        return personRepository.save(person).id.toString();
    }

}
