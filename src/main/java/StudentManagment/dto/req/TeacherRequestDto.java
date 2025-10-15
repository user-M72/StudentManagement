package StudentManagment.dto.req;

import java.time.LocalDateTime;
import java.util.UUID;

public record TeacherRequestDto (
        UUID userId,
        String employeeId,
        String specialization,
        LocalDateTime hireDate,
        UUID departmentId
){}
