package StudentManagment.mapper;

import StudentManagment.dto.req.EnrollmentRequestDto;
import StudentManagment.dto.res.EnrollmentResponseDto;
import StudentManagment.entity.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnrollmentMapper {

    EnrollmentResponseDto toDto(Enrollment enrollment);
    Enrollment toEntity(EnrollmentRequestDto dto);
}
