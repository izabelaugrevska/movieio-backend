package mk.ukim.mk.movieio.web;

import mk.ukim.mk.movieio.model.Customer;
import mk.ukim.mk.movieio.service.AuthService;
import mk.ukim.mk.movieio.web.dto.LoginDto;
import mk.ukim.mk.movieio.web.responses.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/login")
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto)
    {
        try{
            Customer c = authService.login(loginDto.getUsername(), loginDto.getPassword());
            return ResponseEntity.ok(new LoginResponse(true, "User logged in successfully",
                    c.getId()));
        }catch (Exception e)
        {
            return ResponseEntity.badRequest().body
                    (new LoginResponse(false, e.getMessage(), null));
        }
    }
}
