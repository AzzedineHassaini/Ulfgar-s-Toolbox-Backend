package be.azz.java.ulfgarstoolbox.config.configs;

import be.azz.java.ulfgarstoolbox.config.utils.Constants;
import be.azz.java.ulfgarstoolbox.config.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final UserDetailsService userDetailsService;
    private final UserDetailsChecker userDetailsChecker;

    /**
     * Check if the request should not be filtered.
     * The request should not be filtered if the servlet path starts with {@value Constants#AUTH_ENDPOINT}.
     * @param request The request to check.
     * @return True if the request should not be filtered, false otherwise.
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getServletPath().startsWith(Constants.AUTH_ENDPOINT);
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        String authHeader = request.getHeader(Constants.AUTH_HEADER);

        if (authHeader != null && authHeader.startsWith(Constants.JWT_TOKEN_PREFIX)) {
            String token = authHeader.substring(7);

            if (!token.isBlank() && jwtUtils.validateToken(token)) {
                String username = jwtUtils.getUsername(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                userDetailsChecker.check(userDetails);

                UsernamePasswordAuthenticationToken upt = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

                SecurityContextHolder.getContext().setAuthentication(upt);
            }
        }

        filterChain.doFilter(request, response);
    }
}
