package mk.ukim.mk.movieio.web;

import mk.ukim.mk.movieio.web.dto.CustomerDto;
import mk.ukim.mk.movieio.web.dto.EmployeeDto;
import mk.ukim.mk.movieio.model.Customer;
import mk.ukim.mk.movieio.model.Employee;
import mk.ukim.mk.movieio.model.User;
import mk.ukim.mk.movieio.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping
//    public List<User> getMovieProjections() {
//        return userService.findAll();
//    }
    @GetMapping("/get")
    public List<User> getUsers() {

        return userService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<User> save(@RequestBody User user) {
        return this.userService.save(user)
                .map(product -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/addemployee")
    public Optional<Employee> save(@RequestBody EmployeeDto employeeDto) {
        return userService.saveEmployee(employeeDto);
    }

    @GetMapping("/getemployees")
    public List<Employee> getEmployees() {

        return userService.findAllEmployees();
    }

    @PostMapping("/addcustomer")
    public Optional<Customer> save(@RequestBody CustomerDto customerDto) {
        return userService.saveCustomer(customerDto);
    }

    @GetMapping("/getcustomers")
    public List<Customer> getCustomers() {

        return userService.findAllCustomers();
    }
}
