package calvin.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import calvin.demo.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String email);
    Optional<User> findByUsername(String email);
}
