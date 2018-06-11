package com.example.rest.jpa

import com.example.dto.CreatePersonDto
import com.example.dto.CreateRandomPeopleDto
import com.example.dto.PersonDto
import com.example.dto.UpdatePersonDto
import org.springframework.stereotype.Service

@Service
class PersonService internal constructor(val repository: PersonRepository) {

    fun getAllPeople() = repository.findAll().map { it.toDto() }

    fun addPerson(dto: CreatePersonDto): Int {
        val person = Person.fromDto(dto)
        val savedPerson = repository.save(person)
        return savedPerson.id
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

    fun addRandomPeople(dto: CreateRandomPeopleDto): List<PersonDto> {
        val randomPeopleCount = RandomGenerator.randomInt(dto.a, dto.b)
        return List(randomPeopleCount) {
            val randomPerson = Person.random()
            val savedPerson = repository.save(randomPerson)
            savedPerson.toDto()
        }
    }
}
