package StudentManagment.repository;

import StudentManagment.entity.Enum.RoleEnum;
import StudentManagment.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByName(RoleEnum admin);
}
