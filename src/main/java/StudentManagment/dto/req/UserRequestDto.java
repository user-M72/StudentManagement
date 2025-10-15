package StudentManagment.dto.req;

import java.util.Set;
import java.util.UUID;

public record UserRequestDto(
        String username,
        String password,
        String email,
        String firstName,
        String lastName,
        String phoneNumber,
        Set<UUID> roleIds
) {
}
