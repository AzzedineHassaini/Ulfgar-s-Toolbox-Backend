package be.azz.java.ulfgarstoolbox.config.utils;

import be.azz.java.ulfgarstoolbox.dal.repositories.RuleBookRepository;
import be.azz.java.ulfgarstoolbox.dal.repositories.UserRepository;
import be.azz.java.ulfgarstoolbox.domain.entities.RuleBook;
import be.azz.java.ulfgarstoolbox.domain.entities.User;
import be.azz.java.ulfgarstoolbox.domain.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RuleBookRepository ruleBookRepository;

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

        if (ruleBookRepository.count() == 0) {
            List<RuleBook> ruleBooks = new ArrayList<>();
            // Eberron 3.5
            ruleBooks.add(RuleBook.builder()
                    .name("Univers - Eberron")
                    .shortName("EBER")
                    .coverImage("images/Univers - Eberron.jpg")
                    .link("books/Eberron/3.5/Univers - Eberron.pdf")
                    .build());

            // Génériques 3.0
            ruleBooks.add(RuleBook.builder()
                    .name("Campagnes Légendaires")
                    .shortName("C.LEG")
                    .coverImage("images/Campagnes Légendaires.jpg")
                    .link("books/Génériques/3.0/Campagnes Légendaires.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Chapitres Interdits")
                    .shortName("C.INT")
                    .coverImage("images/Chapitres Interdits.jpg")
                    .link("books/Génériques/3.0/Chapitres Interdits.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("D'ombre et de Lumiere")
                    .shortName("O&L")
                    .coverImage("images/D'ombre et de Lumiere.jpg")
                    .link("books/Génériques/3.0/D'ombre et de Lumiere.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("De Chair et d'Acier")
                    .shortName("C&A")
                    .coverImage("images/De Chair et d'Acier.jpg")
                    .link("books/Génériques/3.0/De Chair et d'Acier.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Dieux et Demi-Dieux")
                    .shortName("D&DD")
                    .coverImage("images/Dieux et Demi-Dieux.jpg")
                    .link("books/Génériques/3.0/Dieux et Demi-Dieux.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Fiend Folio")
                    .shortName("F.FOL")
                    .coverImage("images/Fiend Folio.jpg")
                    .link("books/Génériques/3.0/Fiend Folio.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Gardiens de la Foi")
                    .shortName("G.FOI")
                    .coverImage("images/Gardiens de la Foi.jpg")
                    .link("books/Génériques/3.0/Gardiens de la Foi.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Guide de l'Orient")
                    .shortName("G.ORI")
                    .coverImage("images/Guide de l'Orient.jpg")
                    .link("books/Génériques/3.0/Guide de l'Orient.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Guide des Personnages Monstrueux")
                    .shortName("G.P.M")
                    .coverImage("images/Guide des Personnages Monstrueux.jpg")
                    .link("books/Génériques/3.0/Guide des Personnages Monstrueux.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Manuel des Monstres II")
                    .shortName("MM2")
                    .coverImage("images/Manuel des Monstres II.jpg")
                    .link("books/Génériques/3.0/Manuel des Monstres II.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Manuel des Plans")
                    .shortName("M.PLA")
                    .coverImage("images/Manuel des Plans.jpg")
                    .link("books/Génériques/3.0/Manuel des Plans.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Manuel des Psioniques")
                    .shortName("M.PSI")
                    .coverImage("images/Manuel des Psioniques.jpg")
                    .link("books/Génériques/3.0/Manuel des Psioniques.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Maîtres de la Nature")
                    .shortName("M.NAT")
                    .coverImage("images/Maîtres de la Nature.jpg")
                    .link("books/Génériques/3.0/Maîtres de la Nature.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Par l'Encre et le Sang")
                    .shortName("E&S")
                    .coverImage("images/Par l'Encre et le Sang.jpg")
                    .link("books/Génériques/3.0/Par l'Encre et le Sang.pdf")
                    .build());

            // Génériques 3.5
            ruleBooks.add(RuleBook.builder()
                    .name("Guide De Conversion 3.5")
                    .shortName("G.CONV")
                    .coverImage("images/Guide De Conversion 3.5.jpg")
                    .link("books/Génériques/Guide De Conversion 3.5.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Arcanes Exhumées")
                    .shortName("AE")
                    .coverImage("images/Arcanes Exhumées.jpg")
                    .link("books/Génériques/3.5/Arcanes Exhumées.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Chapitres Sacrés")
                    .shortName("CS")
                    .coverImage("images/Chapitres Sacrés.jpg")
                    .link("books/Génériques/3.5/Chapitres Sacrés.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Codex Aventureux")
                    .shortName("CAv")
                    .coverImage("images/Codex Aventureux.jpg")
                    .link("books/Génériques/3.5/Codex Aventureux.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Codex Divin")
                    .shortName("CD")
                    .coverImage("images/Codex Divin.jpg")
                    .link("books/Génériques/3.5/Codex Divin.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Codex Martial")
                    .shortName("CM")
                    .coverImage("images/Codex Martial.jpg")
                    .link("books/Génériques/3.5/Codex Martial.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Codex Profane")
                    .shortName("CP")
                    .coverImage("images/Codex Profane.jpg")
                    .link("books/Génériques/3.5/Codex Profane.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Compendium Arcanique")
                    .shortName("CA")
                    .coverImage("images/Compendium Arcanique.jpg")
                    .link("books/Génériques/3.5/Compendium Arcanique.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Draconomicon")
                    .shortName("DRACO")
                    .coverImage("images/Draconomicon.jpg")
                    .link("books/Génériques/3.5/Draconomicon.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Grand Manuel des Psioniques")
                    .shortName("GMPsi")
                    .coverImage("images/Grand Manuel des Psioniques.jpg")
                    .link("books/Génériques/3.5/Grand Manuel des Psioniques.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Guide du Maître")
                    .shortName("GM")
                    .coverImage("images/Guide du Maître.jpg")
                    .link("books/Génériques/3.5/Guide du Maître.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Guide du Voyageur Planaire")
                    .shortName("GVP")
                    .coverImage("images/Guide du Voyageur Planaire.jpg")
                    .link("books/Génériques/3.5/Guide du Voyageur Planaire.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Libris Mortis")
                    .shortName("LM")
                    .coverImage("images/Libris Mortis.jpg")
                    .link("books/Génériques/3.5/Libris Mortis.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Manuel des Joueurs")
                    .shortName("MJ")
                    .coverImage("images/Manuel des Joueurs.jpg")
                    .link("books/Génériques/3.5/Manuel des Joueurs.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Manuel des Monstres I")
                    .shortName("MM1")
                    .coverImage("images/Manuel des Monstres I.jpg")
                    .link("books/Génériques/3.5/Manuel des Monstres I.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Manuel des Monstres III")
                    .shortName("MM3")
                    .coverImage("images/Manuel des Monstres III.jpg")
                    .link("books/Génériques/3.5/Manuel des Monstres III.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Maîtres de la Folie")
                    .shortName("M.FOL")
                    .coverImage("images/Maîtres de la Folie.jpg")
                    .link("books/Génériques/3.5/Maîtres de la Folie.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Races de la Pierre")
                    .shortName("R.PIE")
                    .coverImage("images/Races de la Pierre.jpg")
                    .link("books/Génériques/3.5/Races de la Pierre.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Recueil de Magie")
                    .shortName("R.MAG")
                    .coverImage("images/Recueil de Magie.jpg")
                    .link("books/Génériques/3.5/Recueil de Magie.pdf")
                    .build());

            // Non-Officiels
            ruleBooks.add(RuleBook.builder()
                    .name("Guide des Poisons")
                    .shortName("G.POI")
                    .coverImage("images/Guide des Poisons.jpg")
                    .link("books/Non-Officiels/Guide des Poisons.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Recueil De Magie (Liste de sorts)")
                    .shortName("R.MAG-Liste")
                    .coverImage("images/Recueil De Magie - liste.jpg")
                    .link("books/Non-Officiels/Recueil De Magie.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Reliques et Rituels")
                    .shortName("Rel&Rit")
                    .coverImage("images/Reliques et Rituels.jpg")
                    .link("books/Non-Officiels/Reliques et Rituels.pdf")
                    .build());

            // Royaumes Oubliés 3.0
            ruleBooks.add(RuleBook.builder()
                    .name("Dogmes Et Panthéons")
                    .shortName("D&P")
                    .coverImage("images/Dogmes Et Panthéons.jpg")
                    .link("books/Royaumes Oubliés/3.0/Dogmes Et Panthéons.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("L'Inaccessible Orient")
                    .shortName("ORIENT")
                    .coverImage("images/L'Inaccessible Orient.jpg")
                    .link("books/Royaumes Oubliés/3.0/L'Inaccessible Orient.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Magie de Faerûn")
                    .shortName("MAG.FAE")
                    .coverImage("images/Magie de Faerûn.jpg")
                    .link("books/Royaumes Oubliés/3.0/Magie de Faerûn.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Marches d'Argent")
                    .shortName("M.ARG")
                    .coverImage("images/Marches d'Argent.jpg")
                    .link("books/Royaumes Oubliés/3.0/Marches d'Argent.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Monstres de Faerûn")
                    .shortName("M.FAE")
                    .coverImage("images/Monstres de Faerûn.jpg")
                    .link("books/Royaumes Oubliés/3.0/Monstres de Faerûn.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Races de Faerûn")
                    .shortName("R.FAE")
                    .coverImage("images/Races de Faerûn.jpg")
                    .link("books/Royaumes Oubliés/3.0/Races de Faerûn.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Seigneurs des Ténèbres")
                    .shortName("S.TEN")
                    .coverImage("images/Seigneurs des Ténèbres.jpg")
                    .link("books/Royaumes Oubliés/3.0/Seigneurs des Ténèbres.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Univers - Royaumes Oubliés")
                    .shortName("RO")
                    .coverImage("images/Univers - Royaumes Oubliés.jpg")
                    .link("books/Royaumes Oubliés/3.0/Univers - Royaumes Oubliés.pdf")
                    .build());

            // Royaumes Oubliés 3.5
            ruleBooks.add(RuleBook.builder()
                    .name("Eauprofonde La Cite des Splendeurs")
                    .shortName("EAUPROF")
                    .coverImage("images/Eauprofonde La Cite des Splendeurs.jpg")
                    .link("books/Royaumes Oubliés/3.5/Eauprofonde La Cite des Splendeurs.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Le Sud Étincelant")
                    .shortName("S.ETI")
                    .coverImage("images/Le Sud Étincelant.jpg")
                    .link("books/Royaumes Oubliés/3.5/Le Sud Étincelant.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Les Royaumes Serpents")
                    .shortName("R.SER")
                    .coverImage("images/Les Royaumes Serpents.jpg")
                    .link("books/Royaumes Oubliés/3.5/Les Royaumes Serpents.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Manuel Des Joueurs De Faerûn")
                    .shortName("MJ.FAE")
                    .coverImage("images/Manuel Des Joueurs De Faerûn.jpg")
                    .link("books/Royaumes Oubliés/3.5/Manuel Des Joueurs De Faerûn.pdf")
                    .build());
            ruleBooks.add(RuleBook.builder()
                    .name("Outreterre")
                    .shortName("OUTRE")
                    .coverImage("images/Outreterre.jpg")
                    .link("books/Royaumes Oubliés/3.5/Outreterre.pdf")
                    .build());

            ruleBookRepository.saveAll(ruleBooks);
        }
    }
}
