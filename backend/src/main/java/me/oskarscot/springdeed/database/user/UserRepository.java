package me.oskarscot.springdeed.database.user;

import java.util.Optional;
import me.oskarscot.springdeed.model.internal.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

}
