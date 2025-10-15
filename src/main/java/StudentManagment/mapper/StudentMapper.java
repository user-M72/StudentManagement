package StudentManagment.mapper;

import StudentManagment.dto.req.StudentRequestDto;
import StudentManagment.dto.res.StudentResponseDto;
import StudentManagment.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

    StudentResponseDto toDto(Student student);


    Student toEntity(StudentRequestDto dto);

    void updateFromDto(StudentRequestDto dto, @MappingTarget Student student);

}
