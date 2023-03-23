package mk.ukim.mk.movieio.repository;

import mk.ukim.mk.movieio.model.MovieProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieProjectionRepository extends JpaRepository<MovieProjection, Integer> {
    List<MovieProjection> findAllByMovie_Id(Integer movieId);
}
