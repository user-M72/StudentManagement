package StudentManagment.mapper;

import StudentManagment.dto.req.StudentRequestDto;
import StudentManagment.dto.res.StudentResponseDto;
import StudentManagment.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentResponseDto toDto(Student student);

    @Mapping(target = "name", ignore = true)
    Student toEntity(StudentRequestDto dto);

    void updateFromDto(StudentRequestDto dto, @MappingTarget Student student);

}
