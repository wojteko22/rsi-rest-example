package com.example.rest

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataLoader {

    @Bean
    fun initRoles(repository: PersonRepository) = CommandLineRunner {
        val people = listOf(
            Person("Wojtek", 71.0),
            Person("Damian", 69.5)
        )
        repository.saveAll(people)
    }
}
