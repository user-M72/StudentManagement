package StudentManagment.service.impl;

import StudentManagment.dto.req.TeacherRequestDto;
import StudentManagment.dto.res.TeacherResponseDto;
import StudentManagment.entity.Teacher;
import StudentManagment.entity.User;
import StudentManagment.mapper.TeacherMapper;
import StudentManagment.repository.TeacherRepository;
import StudentManagment.repository.UserRepository;
import StudentManagment.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private TeacherMapper mapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<TeacherResponseDto> get() {
        return teacherRepository.findAll().stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherResponseDto getById(UUID id) {
        return teacherRepository.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    @Override
    public TeacherResponseDto create(TeacherRequestDto dto) {
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.userId()));

        Teacher teacher = mapper.toEntity(dto);
        teacher.setUser(user);
        teacherRepository.save(teacher);
        return mapper.toDto(teacher);
    }

    @Override
    public TeacherResponseDto updated(UUID id, TeacherRequestDto dto) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));

        teacher.setEmployeeId(dto.employeeId());
        teacher.setSpecialization(dto.specialization());
        teacher.setHireDate(dto.hireDate());

        if (dto.userId() != null) {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
            teacher.setUser(user);
        }
        teacherRepository.save(teacher);
        return mapper.toDto(teacher);
    }

    @Override
    public void delete(UUID id) {
        if (!teacherRepository.existsById(id)) {
            throw new RuntimeException("Teacher not found with id: " + id);
        }
        teacherRepository.deleteById(id);
    }
}
