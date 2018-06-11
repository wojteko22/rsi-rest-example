package com.example.rest.jpa

import com.example.dto.CreatePersonDto
import com.example.dto.PersonDto
import com.example.dto.UpdatePersonDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
internal class Person(private var name: String, private var weight: Double) {

    @Id
    @GeneratedValue
    val id: Int = -1

    fun updateUsing(dto: CreatePersonDto) {
        name = dto.name
        weight = dto.weight
    }

    fun updateUsing(dto: UpdatePersonDto) {
        dto.name?.let { name = it }
        dto.weight?.let { weight = it }
    }

    fun toDto() = PersonDto(id, name, weight)

    companion object {

        fun fromDto(dto: CreatePersonDto) = Person(dto.name, dto.weight)

        fun random(): Person {
            val randomString = RandomGenerator.randomName(3, 12)
            val randomWeight = RandomGenerator.randomDouble(30, 130)
            return Person(randomString, randomWeight)
        }
    }
}
