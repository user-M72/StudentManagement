package StudentManagment.dto.res;

import java.util.UUID;

public record CourseResponseDto(
        UUID id,
        String courseCode,
        String title,
        String description,
        Integer credits,
        TeacherResponseDto teacher,
        DepartmentResponseDto department,
        Set<EnrollmentResponseDto> enrollments
) {
}
