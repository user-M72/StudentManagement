package StudentManagment.dto.req;

import StudentManagment.entity.Enum.EnrollmentStatus;

import java.time.LocalDate;
import java.util.UUID;

public record EnrollmentRequestDto(
        UUID studentId,
        UUID courseId,
        LocalDate enrollmentDate,
        String grade,
        EnrollmentStatus status
) {
}
