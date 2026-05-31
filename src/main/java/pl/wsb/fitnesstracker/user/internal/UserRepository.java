package pl.wsb.fitnesstracker.user.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.fitnesstracker.user.api.User;

import java.util.Optional;

// JpaRepository dostarcza komunikacje z baza danych dla encji User.
interface UserRepository extends JpaRepository<User, Long> {
    // Metoda pobiera uzytkownika o konkretnym ID.
    Optional<User> findById(Long id);

}
