package mk.ukim.mk.movieio.service.impl;

import mk.ukim.mk.movieio.web.dto.CustomerDto;
import mk.ukim.mk.movieio.web.dto.EmployeeDto;
import mk.ukim.mk.movieio.model.*;
import mk.ukim.mk.movieio.repository.*;
import mk.ukim.mk.movieio.service.UserService;
import mk.ukim.mk.movieio.service.exceptions.EmailAlreadyExistsException;
import mk.ukim.mk.movieio.service.exceptions.InvalidEmailException;
import mk.ukim.mk.movieio.service.exceptions.InvalidPasswordException;
import mk.ukim.mk.movieio.service.exceptions.InvalidUsernameException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;
    private final GenreRepository genreRepository;
    private final MovieReviewRepository movieReviewRepository;

    public UserServiceImpl(UserRepository userRepository, EmployeeRepository employeeRepository,
                           CustomerRepository customerRepository, MovieReviewRepository movieReviewRepository,
                           GenreRepository genreRepository) {
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
        this.movieReviewRepository = movieReviewRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> save(User user) {
        return Optional.of(userRepository.save(user));
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmbg(employeeDto.getEmbg());
        employee.setRole(employeeDto.getRole());
        employee.setSalary(employeeDto.getSalary());
        try {
            employee.setManager(employeeRepository.findById(employeeDto.getManagerId()).orElse(null));
        }catch (Exception e)
        {
            //
        }
        employee.setGender(employeeDto.getGender());
        employee.setEmploymentTime(employeeDto.getEmploymentTime());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setEmail(employeeDto.getEmail());
        employee.setBirthDate(employeeDto.getBirthDate());
        employee.setPassword(employeeDto.getPassword());
        employee.setUsername(employeeDto.getUsername());

        return Optional.of(employeeRepository.save(employee));
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> saveCustomer(CustomerDto customerDto) {
        if(customerDto.getEmail() == null || customerDto.getEmail().isEmpty()) {
            throw new InvalidEmailException();
        }
        if(customerDto.getUsername() == null || customerDto.getUsername().isEmpty())
        {
            throw new InvalidUsernameException();
        }
        if(customerDto.getPassword() == null || customerDto.getPassword().isEmpty()){
            throw new InvalidPasswordException();
        }
        if(customerRepository.findByUsername(customerDto.getUsername()).isPresent()){
            throw new InvalidUsernameException();
        }
        if(customerRepository.findByEmail(customerDto.getEmail()).isPresent()){
            throw new EmailAlreadyExistsException();
        }
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setGender(customerDto.getGender());
        customer.setEmail(customerDto.getEmail());
        customer.setBirthDate(customerDto.getBirthDate());
        customer.setUsername(customerDto.getUsername());
        customer.setPassword(customerDto.getPassword());
        Genre genre;
        if(customerDto.getGenreId() != null){
            genre = genreRepository.findById(customerDto.getGenreId()).orElse(null);
            customer.setFavoriteGenre(genre.getGenreName());
        }
        List<MovieReview> movieReviews = new ArrayList<>();
        if(customerDto.getMovieReviewsIds() != null && !customerDto.getMovieReviewsIds().isEmpty())
        {
            for(Integer mrwId: customerDto.getMovieReviewsIds()){
                try {
                    movieReviews.add(movieReviewRepository.findById(mrwId).orElse(null));
                }catch (Exception e)
                {
                    //
                }
            }
            customer.setReviews(movieReviews);
        }
        return Optional.of(customerRepository.save(customer));
    }

}
