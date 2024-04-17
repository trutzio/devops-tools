package trutzio.devopstools;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    private final PersonRepository personRepository;

    public EchoController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    // @WithSpan(value = "test span")
    public String echo() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.id = UUID.randomUUID().toString();
            person.name = "John Doe " + i;
            personRepository.save(person);
        }
        return "OK";
    }

}
