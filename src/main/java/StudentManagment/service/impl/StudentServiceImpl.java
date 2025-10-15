package StudentManagment.service.impl;

import StudentManagment.dto.req.StudentRequestDto;
import StudentManagment.dto.res.StudentResponseDto;
import StudentManagment.entity.Student;
import StudentManagment.entity.User;
import StudentManagment.mapper.StudentMapper;
import StudentManagment.repository.StudentRepository;
import StudentManagment.repository.UserRepository;
import StudentManagment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;
    @Autowired
    private StudentMapper mapper;
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<StudentResponseDto> get() {
        return repository.findAll().stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponseDto getById(UUID id) {
        return repository.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public StudentResponseDto created(StudentRequestDto dto) {
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("User nor found with id: " + dto.userId()));

        Student student = mapper.toEntity(dto);
        student.setUser(user);
        repository.save(student);
        return mapper.toDto(student);
    }

    @Override
    public StudentResponseDto updated(UUID id, StudentRequestDto dto) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id" + id));
        student.setStudentId(dto.studentId());
        student.setEnrollmentDate(dto.enrollmentDate());
        student.setGpa(dto.gpa());
        student.setMajor(dto.major());
        student.setYear(dto.year());

        if (dto.userId() != null) {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
            student.setUser(user);
        }
        repository.save(student);
        return mapper.toDto(student);
    }

    @Override
    public void deleted(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
