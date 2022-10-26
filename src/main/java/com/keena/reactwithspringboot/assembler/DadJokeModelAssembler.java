package com.keena.reactwithspringboot.assembler;

import com.keena.reactwithspringboot.controller.DadJokesController;
import com.keena.reactwithspringboot.entity.DadJoke;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DadJokeModelAssembler implements RepresentationModelAssembler<DadJoke, EntityModel<DadJoke>> {
    @Override
    public EntityModel<DadJoke> toModel(DadJoke joke) {
        EntityModel<DadJoke> jokeModel = EntityModel.of(joke,
                linkTo(methodOn(DadJokesController.class).one(joke.getId())).withSelfRel(),
                linkTo(methodOn(DadJokesController.class).all()).withRel("jokes"));

        return jokeModel;
    }
}
