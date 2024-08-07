package be.azz.java.ulfgarstoolbox.bll.services.impls;

import be.azz.java.ulfgarstoolbox.bll.services.IAuthService;
import be.azz.java.ulfgarstoolbox.common.dtos.auth.requests.LoginRequest;
import be.azz.java.ulfgarstoolbox.common.dtos.auth.requests.RegisterRequest;
import be.azz.java.ulfgarstoolbox.common.dtos.auth.responses.UserTokenResponse;
import be.azz.java.ulfgarstoolbox.common.exceptions.auth.LoginFailedException;
import be.azz.java.ulfgarstoolbox.common.exceptions.auth.UserAlreadyExistsException;
import be.azz.java.ulfgarstoolbox.config.utils.JwtUtils;
import be.azz.java.ulfgarstoolbox.dal.repositories.UserRepository;
import be.azz.java.ulfgarstoolbox.domain.entities.User;
import be.azz.java.ulfgarstoolbox.domain.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements UserDetailsService, IAuthService {

    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    private final UserDetailsChecker userDetailsChecker;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public UserTokenResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(LoginFailedException::new);

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new LoginFailedException();
        }

        userDetailsChecker.check(user);

        String token = jwtUtils.generateToken(user);

        return UserTokenResponse.fromEntityWithToken(user, token);
    }

    @Override
    public UserTokenResponse register(RegisterRequest request, Role role) {
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new UserAlreadyExistsException();
        }

        String encodedPassword = passwordEncoder.encode(request.password());

        User user = new User(request.email(), request.pseudo(), encodedPassword, role, request.image());

        userRepository.save(user);

        String token = jwtUtils.generateToken(user);

        return UserTokenResponse.fromEntityWithToken(user, token);
    }

}
