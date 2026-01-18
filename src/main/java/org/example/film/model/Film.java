package org.example.film.model;

import java.util.List;
import org.example.actor.model.Actor;

public record Film(long id, String title, List<Actor> actors) {
}
