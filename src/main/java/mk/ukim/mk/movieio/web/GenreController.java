package mk.ukim.mk.movieio.web;

import mk.ukim.mk.movieio.model.Genre;
import mk.ukim.mk.movieio.service.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/genre")
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }
    @GetMapping
    public List<Genre> getGenres(){
        return genreService.findAll();
    }

    @PostMapping("/addGenre")
    public Genre save(@RequestBody Genre genre){
        return this.genreService.save(genre);
    }
}
