package mk.ukim.mk.movieio.repository;

import mk.ukim.mk.movieio.model.MovieReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MovieReviewRepository extends JpaRepository<MovieReview, Integer> {
}
