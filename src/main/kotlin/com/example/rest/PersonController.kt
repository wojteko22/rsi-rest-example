package com.example.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/people")
class PersonController(val service: PersonService) {

    @GetMapping
    fun getAll() = service.getAll()
}