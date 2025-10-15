package StudentManagment.dto.res;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record TeacherResponseDto(
        UUID id,
        String employeeId,
        String specialization,
        LocalDate hireDate,
        UserResponseDto user,
        DepartmentResponseDto department,
        Set<CourseResponseDto> courses
) {
}
