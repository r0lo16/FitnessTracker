package pl.wsb.fitnesstracker.user.internal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsb.fitnesstracker.user.api.UserNotFoundException;
import pl.wsb.fitnesstracker.user.api.UserProvider;

import java.util.List;

/**
 * LAB04 na ocene 4: udostepnia liste podstawowych danych uzytkownikow
 * oraz pobieranie szczegolow wybranego uzytkownika po ID.
 */
@RestController
@RequestMapping("/v1/users")
class UserController {

    private final UserProvider userProvider;

    private final UserMapper userMapper;

    // Spring wstrzykuje serwis odczytu danych oraz mapper zamieniajacy encje na DTO.
    UserController(UserProvider userProvider, UserMapper userMapper) {
        this.userProvider = userProvider;
        this.userMapper = userMapper;
    }

    // Zwraca ID, imie i nazwisko wszystkich uzytkownikow.
    @GetMapping("/simple")
    List<UserSummaryDto> getSimpleUsers() {
        return userProvider.findAllUsers().stream()
                .map(userMapper::toSummaryDto)
                .toList();
    }

    // Zwraca pelne dane uzytkownika znalezionego po ID.
    @GetMapping("/{id}")
    UserDetailsDto getUserById(@PathVariable Long id) {
        return userProvider.getUser(id)
                .map(userMapper::toDetailsDto)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
