package StudentManagment.dto;

import java.util.List;
import java.util.UUID;

public record UserRequestDto(
        String firstname,
        String lastname,
        String phoneNumber,
        String email,
        String password,
        List<UUID> roleIds
) {
}
