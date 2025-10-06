package StudentManagment.service;

import StudentManagment.dto.req.RoleRequestDto;
import StudentManagment.dto.res.RoleResponseDto;
import StudentManagment.entity.Role;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface RoleService {
    List<RoleResponseDto> get();

    Role getById(UUID id);

    RoleResponseDto create(RoleRequestDto dto);

    RoleResponseDto update(UUID id, RoleRequestDto dto);

    void delete(UUID id);

    Set<Role> getByIdList(List<UUID> uuids);
}
