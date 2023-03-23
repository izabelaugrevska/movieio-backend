package mk.ukim.mk.movieio.repository;

import mk.ukim.mk.movieio.model.MovieTheater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieTheaterRepository extends JpaRepository<MovieTheater, Integer> {
}
