package com.example.rest.jpa

import com.example.dto.CreatePersonDto
import com.example.dto.UpdatePersonDto
import org.springframework.stereotype.Service

@Service
class PersonService internal constructor(val repository: PersonRepository) {

    fun getAllPeople() = repository.findAll().map { it.toDto() }

    fun addPerson(dto: CreatePersonDto) {
        val person = Person.fromDto(dto)
        repository.save(person)
    }

    fun replacePerson(id: Int, dto: CreatePersonDto) {
        val person = repository.getOne(id)
        person.updateUsing(dto)
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
