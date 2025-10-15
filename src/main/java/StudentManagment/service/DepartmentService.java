package StudentManagment.service;

import StudentManagment.dto.req.DepartmentRequestDto;
import StudentManagment.dto.res.DepartmentResponseDto;

import java.util.List;
import java.util.UUID;


public interface DepartmentService {

    List<DepartmentResponseDto> get();

    DepartmentResponseDto getByID(UUID id);

    DepartmentResponseDto create(DepartmentRequestDto dto);

    DepartmentResponseDto update(UUID id, DepartmentRequestDto dto);

    void delete(UUID id);
}
