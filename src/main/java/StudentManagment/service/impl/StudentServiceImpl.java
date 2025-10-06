package StudentManagment.service.impl;

import StudentManagment.dto.req.StudentRequestDto;
import StudentManagment.dto.res.StudentResponseDto;
import StudentManagment.entity.Student;
import StudentManagment.mapper.StudentMapper;
import StudentManagment.repository.StudentRepository;
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


    @Override
    public List<StudentResponseDto> get() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public StudentResponseDto getById(UUID id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public StudentResponseDto created(StudentRequestDto dto) {
        Student student = mapper.toEntity(dto);
        Student save = repository.save(student);
        return mapper.toDto(save);
    }

    @Override
    public StudentResponseDto updated(UUID id, StudentRequestDto dto) {
        Student student = repository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(dto.name());
        student.setPhone(dto.phone());
        student.setEmail(dto.email());

        Student updated = repository.save(student);
        return mapper.toDto(updated);
    }

    @Override
    public void deleted(UUID id) {
        repository.deleteById(id);
    }
}
