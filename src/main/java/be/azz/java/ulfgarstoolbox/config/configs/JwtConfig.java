package be.azz.java.ulfgarstoolbox.config.configs;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**<h1>JWT Configuration</h1>
 * <p>
 * This class is responsible for JWT configuration.
 * It is annotated with @Component to indicate that an instance of this class should be created at startup.
 * It is also annotated with @ConfigurationProperties(prefix = "jwt") to bind properties prefixed with "jwt"
 * from the application's configuration files to this class's fields.
 * </p>
 * <p>
 * The class has three fields: algorithm, secret, and expireAt, which represent the JWT algorithm, secret key,
 * and expiration time respectively. These fields are populated with values from the application's configuration files.
 * </p>
 * <p>
 * The class also has a SecretKey field, secretKey, which is used to store the secret key in a format suitable for
 * creating a JWT signature. This field is populated in the init method, which is annotated with @PostConstruct
 * to ensure it is executed after Spring has completed the field injection.
 * </p>
 */
@Component
@ConfigurationProperties(prefix = "jwt")
@Getter
@Setter
public class JwtConfig {

    private String algorithm;
    private String secret;
    private long expireAt;

    private SecretKey secretKey;

    /**
     * This method is executed after Spring has completed the field injection.
     * It creates a new SecretKeySpec object using the secret and algorithm fields and assigns it to the secretKey field.
     */
    @PostConstruct
    public void init() {
        this.secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), algorithm);
    }
}