package pl.wsb.fitnesstracker.user.internal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserProvider;
import pl.wsb.fitnesstracker.user.api.UserService;

import java.util.List;
import java.util.Optional;

@Service
class UserServiceImpl implements UserService, UserProvider {

    // Jawny logger zastępuje generowanie pola przez Lombok podczas kompilacji Maven.
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    // Spring wstrzykuje repozytorium odpowiedzialne za odczyt danych z bazy.
    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(final User user) {
        LOG.info("Creating User {}", user);
        if (user.getId() != null) {
            throw new IllegalArgumentException("User has already DB ID, update is not permitted!");
        }
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUser(final Long userId) {
        // Odczyt pojedynczego uzytkownika po ID dla endpointu szczegolow.
        return userRepository.findById(userId);
    }

    @Override
    public List<User> findAllUsers() {
        // Odczyt wszystkich uzytkownikow dla endpointu listy podstawowej.
        return userRepository.findAll();
    }

}
