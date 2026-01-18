package org.example.film.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.example.actor.model.Actor;
import org.example.film.model.Film;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class FilmRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public FilmRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Optional<Film> findFilmWithActors(long filmId) {
        Film film = jdbc.query(FilmSQLQuery.FIND_FILM_WITH_ACTORS_SQL,
                new MapSqlParameterSource("filmId", filmId),
                rs -> {
                    Film f = null;
                    List<Actor> actors = new ArrayList<>();

                    while (rs.next()) {
                        if (f == null) {
                            f = new Film(
                                    rs.getLong("film_id"),
                                    rs.getString("title"),
                                    actors
                            );
                        }
                        actors.add(new Actor(
                                rs.getLong("actor_id"),
                                rs.getString("first_name"),
                                rs.getString("last_name")
                        ));
                    }

                    return f;
                });

        return Optional.ofNullable(film);
    }
}
