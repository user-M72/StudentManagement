package StudentManagment.service.impl;

import StudentManagment.dto.req.EnrollmentRequestDto;
import StudentManagment.dto.res.EnrollmentResponseDto;
import StudentManagment.service.EnrollmentService;

import java.util.List;
import java.util.UUID;

public class EnrollmentServiceImpl implements EnrollmentService {
    @Override
    public List<EnrollmentResponseDto> get() {
        return List.of();
    }

    @Override
    public EnrollmentResponseDto getById(UUID id) {
        return null;
    }

    @Override
    public EnrollmentResponseDto create(EnrollmentRequestDto dto) {
        return null;
    }

    @Override
    public EnrollmentResponseDto update(UUID id, EnrollmentRequestDto dto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
