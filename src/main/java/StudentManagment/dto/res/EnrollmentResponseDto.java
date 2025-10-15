package StudentManagment.dto.res;

import java.time.LocalDate;
import java.util.UUID;

public record EnrollmentResponseDto(
        UUID id,
        LocalDate enrollmentDate,
        String grade,
        String status,
        StudentShortResponseDto student,
        CourseShortResponseDto course
) {
}
