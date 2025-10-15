package StudentManagment.mapper;

import StudentManagment.dto.req.DepartmentRequestDto;
import StudentManagment.dto.res.DepartmentResponseDto;
import StudentManagment.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapper {

    DepartmentResponseDto toDto(Department department);
    Department toEntity(DepartmentRequestDto dto);
}
