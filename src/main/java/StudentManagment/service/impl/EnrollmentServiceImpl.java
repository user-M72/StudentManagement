package StudentManagment.service.impl;

import StudentManagment.dto.req.EnrollmentRequestDto;
import StudentManagment.dto.res.EnrollmentResponseDto;
import StudentManagment.entity.Course;
import StudentManagment.entity.Enrollment;
import StudentManagment.entity.Student;
import StudentManagment.mapper.EnrollmentMapper;
import StudentManagment.repository.CourseRepository;
import StudentManagment.repository.EnrollmentRepository;
import StudentManagment.repository.StudentRepository;
import StudentManagment.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EnrollmentMapper mapper;

    @Override
    public List<EnrollmentResponseDto> get() {
        return enrollmentRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public EnrollmentResponseDto getById(UUID id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id:" + id));
        return mapper.toDto(enrollment);
    }

    @Override
    public EnrollmentResponseDto create(EnrollmentRequestDto dto) {
        Student student = studentRepository.findById(dto.studentId())
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + dto.studentId()));

        Course course = courseRepository.findById(dto.courseId())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.courseId()));

        Enrollment enrollment = mapper.toEntity(dto);
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        Enrollment saved = enrollmentRepository.save(enrollment);
        return mapper.toDto(saved);
    }

    @Override
    public EnrollmentResponseDto update(UUID id, EnrollmentRequestDto dto) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));

        Student student = studentRepository.findById(dto.studentId())
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + dto.studentId()));

        Course course = courseRepository.findById(dto.courseId())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.courseId()));

        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(dto.enrollmentDate());
        enrollment.setGrade(dto.grade());
        enrollment.setStatus(dto.status());

        Enrollment updated = enrollmentRepository.save(enrollment);
        return mapper.toDto(updated);

    }

    @Override
    public void delete(UUID id) {
        if (!enrollmentRepository.existsById(id)) {
            throw new RuntimeException("Enrollment not found with id: " + id);
        }
        enrollmentRepository.deleteById(id);
    }
}
