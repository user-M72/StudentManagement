package StudentManagment.service;

import StudentManagment.dto.req.StudentRequestDto;
import StudentManagment.dto.res.StudentResponseDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    List<StudentResponseDto> get();

    StudentResponseDto getById(UUID id);

    StudentResponseDto created(StudentRequestDto dto);

    StudentResponseDto updated(UUID id, StudentRequestDto dto);

    void deleted(UUID id);
}
