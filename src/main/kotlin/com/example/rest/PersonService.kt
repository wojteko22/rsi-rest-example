package com.example.rest

import org.springframework.stereotype.Service

@Service
class PersonService(val repository: PersonRepository) {

    fun getAllPeople(): Iterable<Person> = repository.findAll()

    fun addPerson(person: Person) {
        repository.save(person)
    }

    fun replacePerson(id: Int, newPerson: Person) {
        val person = repository.getOne(id)
        person.updateUsing(newPerson)
        repository.save(person)
    }

    fun updatePerson(id: Int, dto: UpdatePersonDto) {
        val person = repository.getOne(id)
        person.updateUsing(dto)
        repository.save(person)
    }

    fun deletePerson(id: Int) {
        repository.deleteById(id)
    }
}
