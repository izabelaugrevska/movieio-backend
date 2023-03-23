package mk.ukim.mk.movieio.repository;

import mk.ukim.mk.movieio.model.SeatReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatReviewRepository extends JpaRepository<SeatReview, Integer> {
}
