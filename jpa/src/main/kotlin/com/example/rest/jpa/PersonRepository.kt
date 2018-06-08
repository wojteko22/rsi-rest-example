package com.example.rest.jpa

import org.springframework.data.jpa.repository.JpaRepository

internal interface PersonRepository : JpaRepository<Person, Int>
