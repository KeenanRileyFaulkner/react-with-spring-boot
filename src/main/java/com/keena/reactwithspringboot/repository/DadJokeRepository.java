package com.keena.reactwithspringboot.repository;

import com.keena.reactwithspringboot.entity.DadJoke;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadJokeRepository extends JpaRepository<DadJoke, Long> {
}
