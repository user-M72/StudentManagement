package StudentManagment.dto.req;

import java.time.LocalDate;
import java.util.UUID;

public record StudentRequestDto(
        UUID userId,
        String studentId,
        LocalDate enrollmentDate,
        Double gpa,
        String major,
        Integer year
) {
}
