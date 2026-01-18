package org.example.actor.repository;

public class ActorSQLQuery {

    private ActorSQLQuery() {
    }

    public static final String FIND_ACTOR_BY_ID = """
            SELECT actor_id, first_name, last_name
            FROM actor
            WHERE actor_id = :id;
            """;
}
