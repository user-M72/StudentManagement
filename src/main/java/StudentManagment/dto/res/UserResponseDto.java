package StudentManagment.dto.res;

import java.util.Set;
import java.util.UUID;

public record UserResponseDto(
        UUID id,
        String username,
        String email,
        String firstName,
        String lastName,
        String phoneNumber,
        Set<RoleResponseDto> roles
) {
}
