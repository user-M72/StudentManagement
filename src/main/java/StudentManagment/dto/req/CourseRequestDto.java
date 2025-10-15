package StudentManagment.dto.req;

import java.util.UUID;

public record CourseRequestDto(
        String courseCode,
        String title,
        String description,
        Integer credits,
        UUID teacherId,
        UUID departmentId
) {
}
