package StudentManagment.service.impl;

import StudentManagment.dto.req.CourseRequestDto;
import StudentManagment.dto.res.CourseResponseDto;
import StudentManagment.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {


    @Override
    public List<CourseResponseDto> get() {
        return List.of();
    }

    @Override
    public CourseResponseDto getById(UUID id) {
        return null;
    }

    @Override
    public CourseResponseDto created(CourseRequestDto dto) {
        return null;
    }

    @Override
    public CourseResponseDto update(UUID id, CourseRequestDto dto) {
        return null;
    }

    @Override
    public void delete(UUID id) {
    }
}
