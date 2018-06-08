package com.example.rest

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Person(var name: String, var weight: Double) {

    @Id
    @GeneratedValue
    val id: Int = -1

    fun updateUsing(person: Person) {
        name = person.name
        weight = person.weight
    }

    fun updateUsing(dto: UpdatePersonDto) {
        dto.name?.let { name = it }
        dto.weight?.let { weight = it }
    }
}
