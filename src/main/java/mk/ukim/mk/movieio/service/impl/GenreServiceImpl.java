package mk.ukim.mk.movieio.service.impl;

import mk.ukim.mk.movieio.model.Genre;
import mk.ukim.mk.movieio.repository.GenreRepository;
import mk.ukim.mk.movieio.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre save(Genre genre) {

        return genreRepository.save(genre);
    }
}
