package StudentManagment.dto.res;

import StudentManagment.entity.Enum.EnrollmentStatus;

import java.time.LocalDate;
import java.util.UUID;

public record EnrollmentResponseDto(
        UUID id,
        LocalDate enrollmentDate,
        String grade,
        EnrollmentStatus status,
        StudentShortResponseDto student,
        CourseShortResponseDto course
) {
}
