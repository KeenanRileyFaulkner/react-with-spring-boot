package com.keena.reactwithspringboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class DadJoke {
    private String joke;
    private @Id @GeneratedValue Long id;

    public DadJoke() {}
    public DadJoke(String joke) {
        this.joke = joke;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DadJoke dadJoke = (DadJoke) o;
        return Objects.equals(joke, dadJoke.joke) && Objects.equals(id, dadJoke.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(joke, id);
    }

    @Override
    public String toString() {
        return "DadJoke{" +
                "joke='" + joke + '\'' +
                ", id=" + id +
                '}';
    }
}
