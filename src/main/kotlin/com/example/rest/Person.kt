package com.example.rest

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Person(val name: String, val weight: Double) {

    @Id
    @GeneratedValue
    val id: Int = -1
}
