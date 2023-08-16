package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/people")
    public Person createPerson(@RequestBody Person p){
        personRepository.save(p);
        return p;
    }

    @GetMapping("/people/{id}")
    public Person getPerson(@PathVariable Long id){
        return personRepository.findOne(id);

    }

    @GetMapping("/people")
    public List<Person> getPersonList(){
        return (List<Person>) personRepository.findAll();
    }

    @PutMapping("/people")
    public Person updatePerson(@RequestBody Person p){
        Person temp = getPerson(p.getId());
        personRepository.save(temp);
        return p;
    };

    @DeleteMapping("/people/{id}")
    void deletePerson(Long id){
        personRepository.delete(id);
    }

}
