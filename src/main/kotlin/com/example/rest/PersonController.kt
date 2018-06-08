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

    @PutMapping("/{id}")
    fun replacePerson(@PathVariable id: Int, @RequestBody newPerson: Person) {
        service.replacePerson(id, newPerson)
    }

    @PatchMapping("/{id}")
    fun updatePerson(@PathVariable id: Int, @RequestBody dto: UpdatePersonDto) {
        service.updatePerson(id, dto)
    }
}
