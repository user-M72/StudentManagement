package StudentManagment.service;

import StudentManagment.dto.req.CourseRequestDto;
import StudentManagment.dto.res.CourseResponseDto;

import java.util.List;
import java.util.UUID;


public interface CourseService {

    List<CourseResponseDto> get();

    CourseResponseDto getById(UUID id);

    CourseResponseDto created(CourseRequestDto dto);

    CourseResponseDto update(UUID id, CourseRequestDto dto);

    void delete(UUID id);
}
