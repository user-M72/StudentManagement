package StudentManagment.dto.res;

import java.util.Set;
import java.util.UUID;

public record DepartmentResponseDto(
        UUID id,
        String name,
        String code,
        String description,
        Set<TeacherResponseDto> teachers,
        Set<CourseResponseDto> courses
) {
}
