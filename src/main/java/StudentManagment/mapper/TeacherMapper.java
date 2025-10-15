package StudentManagment.mapper;

import StudentManagment.dto.req.TeacherRequestDto;
import StudentManagment.dto.res.TeacherResponseDto;
import StudentManagment.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeacherMapper {

    TeacherResponseDto toDto(Teacher teacher);
    Teacher toEntity(TeacherRequestDto dto);
}
