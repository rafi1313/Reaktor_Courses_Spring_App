package reaktor.reaktorapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reaktor.reaktorapp.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByEmail(String email);
}
