package StudentManagment.dto.res;

import StudentManagment.entity.Role;

import java.util.Set;
import java.util.UUID;

public record UserResponseDto(
        UUID id,
        String username,
        String password,
        String email,
        Set<Role> roles
) {
}
