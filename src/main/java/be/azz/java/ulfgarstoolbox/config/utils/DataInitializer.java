package be.azz.java.ulfgarstoolbox.config.utils;

import be.azz.java.ulfgarstoolbox.dal.repositories.UserRepository;
import be.azz.java.ulfgarstoolbox.domain.entities.User;
import be.azz.java.ulfgarstoolbox.domain.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Méthode exécutée au démarrage de l'application pour initialiser les données.
     * @param args les arguments de la ligne de commande, s'ils existent
     */

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            User admin = new User("wahib7134@gmail.com", "Ulfgar", passwordEncoder.encode("Test1234="), Role.ADMIN);
            User contributor = new User("contributor@gmail.com", "TestContributor", passwordEncoder.encode("Test1234="), Role.CONTRIBUTOR);
            User user = new User("user@gmail.com", "TestUser", passwordEncoder.encode("Test1234="), Role.USER);

            userRepository.save(admin);
            userRepository.save(contributor);
            userRepository.save(user);

        }
    }
}
