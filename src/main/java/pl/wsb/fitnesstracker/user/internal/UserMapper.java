package pl.wsb.fitnesstracker.user.internal;

import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.user.api.User;

@Component
class UserMapper {

    // Mapowanie do DTO z ograniczonym zestawem danych dla listy uzytkownikow.
    UserSummaryDto toSummaryDto(User user) {
        return new UserSummaryDto(user.getId(), user.getFirstName(), user.getLastName());
    }

    // Mapowanie do DTO zawierajacego pelne szczegoly pojedynczego uzytkownika.
    UserDetailsDto toDetailsDto(User user) {
        return new UserDetailsDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthdate(),
                user.getEmail()
        );
    }

}
