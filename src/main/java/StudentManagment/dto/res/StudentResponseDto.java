package StudentManagment.dto.res;

import java.util.UUID;

public record StudentResponseDto(
        UUID id,
        String name,
        String phone,
        String email

) {
}
