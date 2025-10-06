package StudentManagment.dto.req;

import java.util.List;
import java.util.UUID;

public record UserRequestDto(
        String username,
        String email,
        String password,
        List<UUID> roleIds
) {
}
