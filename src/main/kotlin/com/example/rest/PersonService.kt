package com.example.rest

import org.springframework.stereotype.Service

@Service
class PersonService(val repository: PersonRepository) {

    fun getAllPeople(): List<Person> = repository.findAll()

    fun addPerson(person: Person) {
        repository.save(person)
    }
}
