package StudentManagment.dto.res;

public record EnrollmentResponseDto(
        UUID id,
        LocalDate enrollmentDate,
        String grade,
        String status,
        StudentShortResponseDto student,
        CourseShortResponseDto course
) {
}
