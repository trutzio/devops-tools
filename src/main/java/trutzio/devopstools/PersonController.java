package trutzio.devopstools;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.persistence.EntityManager;

@RestController
public class PersonController {

    private final PersonRepository personRepository;

    private final AddressRepository addressRepository;

    private final EntityManager entityManager;

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(PersonController.class);

    public PersonController(PersonRepository personRepository, EntityManager entityManager, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
        this.entityManager = entityManager;
    }

    @GetMapping("/")
    @WithSpan
    public String newPerson() throws InterruptedException {
        var person = new Person();
        person.name = "John Doe";
        person = personRepository.save(person);
        logger.info("Person saved: {}", person);
        return person.id.toString();
    }

    @GetMapping("/detach")
    @WithSpan
    public String detach() throws InterruptedException {
        Person person = new Person();
        person.name = "John Doe to detach";
        person = personRepository.save(person);
        
        Address address = new Address();
        address.street = "Main Street";
        address.person = person;
        person.addresses = List.of(addressRepository.save(address));

        entityManager.detach(person);
        person.id = null;
        person.name = "John Doe";
        person = personRepository.save(person);
        return person.id.toString();
    }

}
