package mk.ukim.mk.movieio.web;

import mk.ukim.mk.movieio.web.dto.CustomerDto;
import mk.ukim.mk.movieio.service.UserService;
import mk.ukim.mk.movieio.web.responses.RegistrationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody CustomerDto customerDto)
    {
        try{
            userService.saveCustomer(customerDto);
            return ResponseEntity.ok(new RegistrationResponse(true, "User registered successfully"));
        }catch (Exception e)
        {
            return ResponseEntity.badRequest().body
                    (new RegistrationResponse(false, e.getMessage()));
        }
    }
}
