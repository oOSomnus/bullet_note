package han.z.gateway.controller;


import han.z.gateway.model.RegistrationRequest;
import han.z.gateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        if (userService.usernameExists(registrationRequest.getUsername())) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        userService.registerNewUser(registrationRequest);

        return ResponseEntity.ok("User registered successfully");
    }
}
