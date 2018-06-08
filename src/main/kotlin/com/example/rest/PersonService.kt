package com.example.rest

import org.springframework.stereotype.Service

@Service
class PersonService(val repository: PersonRepository) {

    fun getAll(): List<Person> = repository.findAll()
}
