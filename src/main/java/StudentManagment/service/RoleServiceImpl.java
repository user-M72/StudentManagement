package StudentManagment.service;

import StudentManagment.dto.RoleRequestDto;
import StudentManagment.entity.Role;
import StudentManagment.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired private RoleRepository repository;
    @Override
    public List<Role> get() {
        return repository.findAll();
    }

    @Override
    public Role getById(UUID id) {
        Role role = repository.findById(id).orElseThrow(()->new RuntimeException("Role not found"));
        return role;
    }

    @Override
    public RoleRequestDto create(RoleRequestDto dto) {
        return null;
    }

    @Override
    public RoleRequestDto update(UUID id, RoleRequestDto dto) {
        return null;
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
