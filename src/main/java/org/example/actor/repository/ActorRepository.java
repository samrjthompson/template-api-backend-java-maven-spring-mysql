package org.example.actor.repository;

import java.util.List;
import java.util.Optional;
import org.example.actor.model.Actor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ActorRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public ActorRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private static final RowMapper<Actor> ACTOR_MAPPER = (rs, rowNum) ->
            new Actor(
                    rs.getLong("actor_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name")
            );

    public Optional<Actor> findById(long id) {
        List<Actor> results = jdbc.query(ActorSQLQuery.FIND_ACTOR_BY_ID,
                new MapSqlParameterSource("id", id),
                ACTOR_MAPPER);

        return results.stream().findFirst();
    }
}
