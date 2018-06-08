package com.example.rest.jpa

import com.example.dto.CreatePersonDto
import com.example.dto.UpdatePersonDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Person(var name: String, var weight: Double) {

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

    companion object {
        fun fromDto(dto: CreatePersonDto) = Person(dto.name, dto.weight)
    }
}
