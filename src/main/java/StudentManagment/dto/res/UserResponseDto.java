package StudentManagment.dto.res;

import java.util.UUID;

public record UserResponseDto(
        UUID id,
        String username,
        String password,
        String email
) {
}
