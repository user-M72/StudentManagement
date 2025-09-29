package StudentManagment.dto;

import java.util.UUID;

public record UserResponseDto(
        UUID id,
        String firstname,
        String lastname,
        String password,
        String email,
        String phoneNumber
) {
}
