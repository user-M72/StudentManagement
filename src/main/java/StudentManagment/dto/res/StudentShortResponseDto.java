package StudentManagment.dto.res;

import java.util.UUID;

public record StudentShortResponseDto(
        UUID id,
        String studentId,
        String fullName
) {
}
