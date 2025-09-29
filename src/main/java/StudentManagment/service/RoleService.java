package StudentManagment.service;

import StudentManagment.dto.RoleRequestDto;
import StudentManagment.entity.Role;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface RoleService {
    List<Role> get();

    Role getById(UUID id);

    RoleRequestDto create(RoleRequestDto dto);
    RoleRequestDto update(UUID id, RoleRequestDto dto);

    void delete(UUID id);

    Set<Role> getByIdList(List<UUID> uuids);
}
