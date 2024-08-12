package be.azz.java.ulfgarstoolbox.config.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SQLSessionUtils {

    private final JdbcTemplate jdbcTemplate;

    public void setCurrentUserId(Long userId) {
        jdbcTemplate.execute("SET @current_user_id = " + userId);
    }

}
