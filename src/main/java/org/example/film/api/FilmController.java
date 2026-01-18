package org.example.film.api;

import org.example.film.repository.FilmRepository;
import org.example.film.model.Film;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class FilmController {

    private final FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping("/film/{film_id}")
    public ResponseEntity<Film> findFilm(@PathVariable("film_id") long filmId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(filmRepository.findFilmWithActors(filmId)
                        .orElseThrow(RuntimeException::new));
    }
}
