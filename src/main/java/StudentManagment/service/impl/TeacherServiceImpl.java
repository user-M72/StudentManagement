package StudentManagment.service.impl;

import StudentManagment.dto.req.TeacherRequestDto;
import StudentManagment.dto.res.TeacherResponseDto;
import StudentManagment.service.TeacherService;

import java.util.List;
import java.util.UUID;

public class TeacherServiceImpl implements TeacherService {
    @Override
    public List<TeacherResponseDto> get() {
        return List.of();
    }

    @Override
    public TeacherResponseDto getById(UUID id) {
        return null;
    }

    @Override
    public TeacherResponseDto create(TeacherRequestDto dto) {
        return null;
    }

    @Override
    public TeacherResponseDto updated(UUID id, TeacherRequestDto dto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
