package StudentManagment.repository;

import StudentManagment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Object findByUsername(String username);
}
