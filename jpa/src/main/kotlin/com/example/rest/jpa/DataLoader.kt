package com.example.rest.jpa

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class DataLoader {

    @Bean
    fun initRoles(repository: PersonRepository) = CommandLineRunner {
        val people = listOf(
            Person("Wojtek", 71.0f),
            Person("Damian", 69.5f)
        )
        repository.saveAll(people)
    }
}
