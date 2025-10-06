package StudentManagment.service;

import StudentManagment.dto.req.CourseRequestDto;
import StudentManagment.dto.res.CourseResponseDto;

import java.util.List;

public interface CourseService {

    List<CourseResponseDto> get();

    CourseResponseDto created(CourseRequestDto dto);
}
