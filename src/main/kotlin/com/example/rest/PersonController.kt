package com.example.rest

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/people")
class PersonController(val service: PersonService) {

    @GetMapping
    fun getAll() = service.getAllPeople()

    @PostMapping
    fun addPerson(@RequestBody person: Person) {
        service.addPerson(person)
    }
}
