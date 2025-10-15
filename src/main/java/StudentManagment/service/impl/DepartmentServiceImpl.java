package StudentManagment.service.impl;

import StudentManagment.dto.req.DepartmentRequestDto;
import StudentManagment.dto.res.DepartmentResponseDto;
import StudentManagment.service.DepartmentService;

import java.util.List;
import java.util.UUID;

public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public List<DepartmentResponseDto> get() {
        return List.of();
    }

    @Override
    public DepartmentResponseDto getByID(UUID id) {
        return null;
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
