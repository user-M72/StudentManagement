package StudentManagment.service;

import StudentManagment.dto.req.EnrollmentRequestDto;
import StudentManagment.dto.res.EnrollmentResponseDto;

import java.util.List;
import java.util.UUID;


public interface EnrollmentService {
    List<EnrollmentResponseDto> get();

    EnrollmentResponseDto getById(UUID id);

    EnrollmentResponseDto create(EnrollmentRequestDto dto);

    EnrollmentResponseDto update(UUID id, EnrollmentRequestDto dto);

    void delete(UUID id);
}
