package StudentManagment.dto.res;

import java.util.UUID;

public record CourseResponseDto(
        UUID id,
        String title,
        String description
) {
}
