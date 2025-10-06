package StudentManagment.service.impl;

import StudentManagment.dto.req.CourseRequestDto;
import StudentManagment.dto.res.CourseResponseDto;
import StudentManagment.entity.Course;
import StudentManagment.mapper.CourseMapper;
import StudentManagment.repository.CourseRepository;
import StudentManagment.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repository;
    @Autowired
    private CourseMapper mapper;


    @Override
    public List<CourseResponseDto> get() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CourseResponseDto created(CourseRequestDto dto) {
        Course created = mapper.toEntity(dto);
        Course saved = repository.save(created);
        return mapper.toDto(saved);
    }

}
