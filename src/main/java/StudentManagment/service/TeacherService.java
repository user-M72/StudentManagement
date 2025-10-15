package StudentManagment.service;

import StudentManagment.dto.req.TeacherRequestDto;
import StudentManagment.dto.res.TeacherResponseDto;

import java.util.List;
import java.util.UUID;


public interface TeacherService {

    List<TeacherResponseDto> get();

    TeacherResponseDto getById(UUID id);

    TeacherResponseDto create(TeacherRequestDto dto);

    TeacherResponseDto updated(UUID id, TeacherRequestDto dto);

    void delete(UUID id);
}
