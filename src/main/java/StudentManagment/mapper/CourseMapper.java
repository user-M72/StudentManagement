package StudentManagment.mapper;

import StudentManagment.dto.req.CourseRequestDto;
import StudentManagment.dto.res.CourseResponseDto;
import StudentManagment.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseResponseDto toDto(Course course);

    Course toEntity(CourseRequestDto dto);


}
