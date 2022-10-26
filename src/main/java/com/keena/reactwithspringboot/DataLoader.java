package com.keena.reactwithspringboot;

import com.keena.reactwithspringboot.entity.DadJoke;
import com.keena.reactwithspringboot.repository.DadJokeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {
    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Bean
    CommandLineRunner initDatabase(DadJokeRepository jokeRepository) {
        return args -> {
            jokeRepository.save(
                    new DadJoke("Justice is a dish best served cold; if it were served warm, it would be just water")
            );

            jokeRepository.save(
                    new DadJoke("What does a baby computer call its father? Data.")
            );

            jokeRepository.findAll().forEach(joke -> logger.info("Preloaded " + joke));
        };
    }
}
