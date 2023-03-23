package mk.ukim.mk.movieio.service;

import mk.ukim.mk.movieio.web.dto.CustomerDto;
import mk.ukim.mk.movieio.web.dto.EmployeeDto;
import mk.ukim.mk.movieio.model.Customer;
import mk.ukim.mk.movieio.model.Employee;
import mk.ukim.mk.movieio.model.User;
import java.util.*;

public interface UserService {

    List<User> findAll();

    Optional<User> save(User user);

    List<Employee> findAllEmployees();

    Optional<Employee> saveEmployee(EmployeeDto employeeDto);

    List<Customer> findAllCustomers();

    Optional<Customer> saveCustomer(CustomerDto customerDto);

}
