package trutzio.devopstools;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Person {

    @Id
    String id;
    String name;

}