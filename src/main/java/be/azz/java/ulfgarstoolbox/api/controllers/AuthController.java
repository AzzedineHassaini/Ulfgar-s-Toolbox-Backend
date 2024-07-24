package be.azz.java.ulfgarstoolbox.api.controllers;

import be.azz.java.ulfgarstoolbox.bll.services.IAuthService;
import be.azz.java.ulfgarstoolbox.common.dtos.auth.requests.LoginRequest;
import be.azz.java.ulfgarstoolbox.common.dtos.auth.requests.RegisterRequest;
import be.azz.java.ulfgarstoolbox.common.dtos.auth.responses.UserTokenResponse;
import be.azz.java.ulfgarstoolbox.config.utils.Constants;
import be.azz.java.ulfgarstoolbox.domain.enums.Role;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.AUTH_ENDPOINT)
public class AuthController {

    private final IAuthService authService;

    @PreAuthorize("isAnonymous()")
    @PostMapping("/login")
    public ResponseEntity<UserTokenResponse> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/register")
    public ResponseEntity<UserTokenResponse> register(@RequestBody @Valid RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request, Role.USER));
    }

}
