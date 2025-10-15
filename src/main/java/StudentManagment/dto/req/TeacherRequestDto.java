package StudentManagment.dto.req;

import java.time.LocalDate;
import java.util.UUID;

public record TeacherRequestDto (
        UUID userId,
        String employeeId,
        String specialization,
        LocalDate hireDate,
        UUID departmentId
){}
