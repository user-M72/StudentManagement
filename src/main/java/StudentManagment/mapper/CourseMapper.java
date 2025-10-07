package StudentManagment.mapper;

import StudentManagment.dto.req.CourseRequestDto;
import StudentManagment.dto.res.CourseResponseDto;
import StudentManagment.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseResponseDto toDto(Course course);


    @Mapping(target = "title", ignore = true)
    Course toEntity(CourseRequestDto dto);

    @Mapping(target = "id", ignore = true)
    void updateFromDto(CourseRequestDto dto, @MappingTarget Course course);

}
