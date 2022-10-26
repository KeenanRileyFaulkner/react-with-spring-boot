package com.keena.reactwithspringboot.controller;

import com.keena.reactwithspringboot.assembler.DadJokeModelAssembler;
import com.keena.reactwithspringboot.entity.DadJoke;
import com.keena.reactwithspringboot.exception.JokeNotFoundException;
import com.keena.reactwithspringboot.repository.DadJokeRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class DadJokesController {

    private final DadJokeRepository jokeRepository;
    private final DadJokeModelAssembler jokeAssembler;

    public DadJokesController(DadJokeRepository jokeRepository, DadJokeModelAssembler jokeAssembler) {
        this.jokeRepository = jokeRepository;
        this.jokeAssembler = jokeAssembler;
    }


    @GetMapping("/api/dadjokes")
    public CollectionModel<EntityModel<DadJoke>> all() {
        List<EntityModel<DadJoke>> jokes = jokeRepository.findAll().stream()
                .map(jokeAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(jokes, linkTo(methodOn(DadJokesController.class).all()).withSelfRel());
    }

    @GetMapping("/api/dadjokes/{id}")
    public EntityModel<DadJoke> one(@PathVariable Long id) {
        DadJoke joke = jokeRepository.findById(id)
                .orElseThrow(() -> new JokeNotFoundException(id));

        return jokeAssembler.toModel(joke);
    }
}
