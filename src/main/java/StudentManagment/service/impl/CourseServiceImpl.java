package StudentManagment.service.impl;

import StudentManagment.dto.req.CourseRequestDto;
import StudentManagment.dto.res.CourseResponseDto;
import StudentManagment.entity.Course;
import StudentManagment.entity.Department;
import StudentManagment.entity.Teacher;
import StudentManagment.mapper.CourseMapper;
import StudentManagment.repository.CourseRepository;
import StudentManagment.repository.DepartmentRepository;
import StudentManagment.repository.TeacherRepository;
import StudentManagment.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private CourseMapper mapper;

    @Override
    public List<CourseResponseDto> get() {
        return courseRepository.findAll().stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponseDto getById(UUID id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        return mapper.toDto(course);
    }

    @Override
    public CourseResponseDto created(CourseRequestDto dto) {
        Course course = mapper.toEntity(dto);

        Teacher teacher = teacherRepository.findById(dto.teacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + dto.teacherId()));
        course.setTeacher(teacher);

        if (dto.departmentId() != null) {
            Department department = departmentRepository.findById(dto.departmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found with id:" + dto.departmentId()));
            course.setDepartment(department);
        }

        courseRepository.save(course);
        return mapper.toDto(course);
    }

    @Override
    public CourseResponseDto update(UUID id, CourseRequestDto dto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));

        course.setTitle(dto.title());
        course.setDescription(dto.description());
        course.setCredits(dto.credits());

        if (dto.teacherId() != null) {
            Teacher teacher = teacherRepository.findById(dto.teacherId())
                    .orElseThrow(() -> new RuntimeException(("Teacher not found with id: " + dto.teacherId())));
            course.setTeacher(teacher);
        }

        if (dto.departmentId() != null) {
            Department department = departmentRepository.findById(dto.departmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found with id:" + dto.departmentId()));
            course.setDepartment(department);
        }
        courseRepository.save(course);
        return mapper.toDto(course);
    }

    @Override
    public void delete(UUID id) {
        if (!courseRepository.existsById(id)) {
            throw new RuntimeException("Course not found with id:" + id);
        }
        courseRepository.deleteById(id);
    }
}
