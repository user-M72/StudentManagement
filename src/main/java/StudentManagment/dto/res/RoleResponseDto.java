package StudentManagment.dto.res;

import java.util.UUID;

public record RoleResponseDto(
        UUID id,
        String name,
        String description
) {
}
