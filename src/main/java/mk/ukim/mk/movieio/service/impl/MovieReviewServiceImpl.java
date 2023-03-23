package mk.ukim.mk.movieio.service.impl;

import mk.ukim.mk.movieio.web.dto.GetMovieReviewDto;
import mk.ukim.mk.movieio.web.dto.MovieReviewDto;
import mk.ukim.mk.movieio.model.Customer;
import mk.ukim.mk.movieio.model.Movie;
import mk.ukim.mk.movieio.model.MovieReview;
import mk.ukim.mk.movieio.repository.CustomerRepository;
import mk.ukim.mk.movieio.repository.MovieRepository;
import mk.ukim.mk.movieio.repository.MovieReviewRepository;
import mk.ukim.mk.movieio.repository.UserRepository;
import mk.ukim.mk.movieio.service.MovieReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieReviewServiceImpl implements MovieReviewService {

//    private final MovieReviewRepository movieReviewRepository;
//    private final MovieRepository movieRepository;
//    private final UserRepository userRepository;
//
//    public MovieReviewServiceImpl(MovieReviewRepository movieReviewRepository, MovieRepository movieRepository,
//                                  UserRepository userRepository) {
//        this.movieReviewRepository = movieReviewRepository;
//        this.movieRepository = movieRepository;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public MovieReview save(MovieReviewDto reviewDto) {
//        User user = userRepository.findById(reviewDto.getUserId()).orElseThrow(() -> new RuntimeException("Movie not found"));
//        Movie movie = movieRepository.findById(reviewDto.getMovieId()).orElseThrow(() -> new RuntimeException("Movie not found"));
//
//        MovieReview review = new MovieReview();
//        review.setMovie(movie);
//        review.setDate(reviewDto.getDate());
//        review.setDescription(reviewDto.getDescription());
//        review.setRating(reviewDto.getRating());
//        review.setUser(user);
//
//        return movieReviewRepository.save(review);
//    }

    private final MovieReviewRepository movieReviewRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;

    public MovieReviewServiceImpl(MovieReviewRepository movieReviewRepository, MovieRepository movieRepository,
                                  UserRepository userRepository, CustomerRepository customerRepository) {
        this.movieReviewRepository = movieReviewRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<GetMovieReviewDto> findAll() {
        List<GetMovieReviewDto> getMovieReviewDtoList = new ArrayList<>();
        List<MovieReview> movieReviews = movieReviewRepository.findAll();

        for(MovieReview movieReview : movieReviews) {
            GetMovieReviewDto getMovieReviewDto = new GetMovieReviewDto(movieReview.getDescription(),
                    movieReview.getRating(), movieReview.getReviewDate(), movieReview.getMovie().getId(),
                    movieReview.getCustomer().getId());

            getMovieReviewDtoList.add(getMovieReviewDto);
        }
        return getMovieReviewDtoList;
    }

    @Override
    public Optional<MovieReview> save(MovieReviewDto movieReviewDto) {
        if(movieReviewDto.getReviewDate() == null)
        {
            movieReviewDto.setReviewDate(LocalDate.now());
        }
        Optional<Movie> optionalMovie = movieRepository.findById(movieReviewDto.getMovieId());
        Movie movie = optionalMovie.orElse(null);
//        Optional<User> optionalUser = userRepository.findById(movieReviewDto.getUserId());
//        User user = optionalUser.orElse(null);
        Optional<Customer> optionalCustomer = customerRepository.findById(movieReviewDto.getUserId());
        Customer customer = optionalCustomer.orElse(null);
        MovieReview movieReview = new MovieReview(movieReviewDto.getDescription(), movieReviewDto.getRating(),
                movieReviewDto.getReviewDate(), movie, customer);
        return Optional.of(movieReviewRepository.save(movieReview));
    }


}
