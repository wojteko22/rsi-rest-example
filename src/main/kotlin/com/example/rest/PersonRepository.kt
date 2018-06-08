package com.example.rest

import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Int>
