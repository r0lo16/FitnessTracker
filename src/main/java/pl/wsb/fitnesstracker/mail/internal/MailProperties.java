package pl.wsb.fitnesstracker.mail.internal;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.javamail.JavaMailSender;
import pl.wsb.fitnesstracker.mail.api.EmailSender;

/**
 * Configuration of the {@link EmailSender} (additional to the Spring mail configuration for {@link JavaMailSender} bean autoconfiguration).
 */
@ConfigurationProperties(prefix = "mail")
class MailProperties {

    /**
     * Email address that the email should be sent from.
     */
    private final String from;

    MailProperties(String from) {
        // Jawny konstruktor umozliwia utworzenie konfiguracji bez generowania kodu przez Lombok.
        this.from = from;
    }

    // Getter udostepnia skonfigurowany adres nadawcy pozostalej czesci modulu mail.
    String getFrom() {
        return from;
    }

}
