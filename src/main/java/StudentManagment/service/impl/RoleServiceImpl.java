package StudentManagment.service.impl;

import StudentManagment.dto.req.RoleRequestDto;
import StudentManagment.dto.res.RoleResponseDto;
import StudentManagment.entity.Role;
import StudentManagment.mapper.RoleMapper;
import StudentManagment.repository.RoleRepository;
import StudentManagment.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RoleResponseDto> get() {
        return repository.findAll().stream().map(roleMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Role getById(UUID id) {
        Role role = repository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        return role;
    }

    @Override
    public RoleResponseDto create(RoleRequestDto dto) {
        Role role = roleMapper.toEntity(dto);
        return roleMapper.toDto(repository.save(role));
    }

    @Override
    public RoleResponseDto update(UUID id, RoleRequestDto dto) {
        Role role = repository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        roleMapper.updateFromDto(dto, role);
        return roleMapper.toDto(repository.save(role));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Set<Role> getByIdList(List<UUID> uuids) {
        return new HashSet<>(repository.findAllById(uuids));
    }
}
