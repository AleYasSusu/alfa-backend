package ages.alfa.api.controller;

import ages.alfa.api.AuthenticationApi;
import ages.alfa.model.IUser;
import ages.alfa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthenticationController implements AuthenticationApi {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<IUser> auth(@RequestParam("email") final String email) {
        return ResponseEntity.ok().body(userService.auth(email));
    }
}
