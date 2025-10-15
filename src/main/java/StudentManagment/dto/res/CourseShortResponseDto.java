package StudentManagment.dto.res;

import java.util.UUID;

public record CourseShortResponseDto(
        UUID id,
        String courseCode,
        String name
) {
}
