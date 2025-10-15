package StudentManagment.dto.res;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record TeacherResponseDto(
        UUID id,
        String employeeId,
        String specialization,
        LocalDateTime hireDate,
        UserResponseDto user,
        DepartmentResponseDto department,
        Set<CourseResponseDto> courses
) {
}
