package StudentManagment.service.impl;

import StudentManagment.dto.req.DepartmentRequestDto;
import StudentManagment.dto.res.DepartmentResponseDto;
import StudentManagment.entity.Department;
import StudentManagment.mapper.DepartmentMapper;
import StudentManagment.repository.CourseRepository;
import StudentManagment.repository.DepartmentRepository;
import StudentManagment.repository.TeacherRepository;
import StudentManagment.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private DepartmentMapper mapper;

//todo: continue next day

    @Override
    public List<DepartmentResponseDto> get() {
        return departmentRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public DepartmentResponseDto getByID(UUID id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
        return mapper.toDto(department);
    }

    @Override
    public DepartmentResponseDto create(DepartmentRequestDto dto) {
        return null;
    }

    @Override
    public DepartmentResponseDto update(UUID id, DepartmentRequestDto dto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
