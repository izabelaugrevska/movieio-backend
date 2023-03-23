package mk.ukim.mk.movieio.service;

import mk.ukim.mk.movieio.model.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> findAll();
    Genre save(Genre genre);
}
