package StudentManagment.dto.res;

import java.time.LocalDate;
import java.util.UUID;

public record StudentResponseDto(
        UUID id,
        String studentId,
        LocalDate enrollmentDate,
        Double gpa,
        String major,
        Integer year,
        UserResponseDto user,
        Set<EnrollmentResponseDto> enrollments

) {
}
