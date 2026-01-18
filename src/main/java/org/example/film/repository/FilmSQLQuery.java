package org.example.film.repository;

public class FilmSQLQuery {

    private FilmSQLQuery() {
    }

    public static final String FIND_FILM_WITH_ACTORS_SQL = """
            SELECT f.film_id,
                   f.title,
                   a.actor_id,
                   a.first_name,
                   a.last_name
            FROM film f
                     JOIN film_actor fa ON fa.film_id = f.film_id
                     JOIN actor a ON a.actor_id = fa.actor_id
            WHERE f.film_id = :filmId
            ORDER BY f.title;
            """;
}
