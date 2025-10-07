package StudentManagment.API;

import StudentManagment.dto.req.RoleRequestDto;
import StudentManagment.dto.res.RoleResponseDto;
import StudentManagment.entity.Role;
import StudentManagment.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/roles/v1")
public class RoleApi {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<RoleResponseDto> get() {
        return roleService.get();
    }

    @GetMapping("/{userId}")
    public Role getById(@PathVariable("userId") UUID id) {
        return roleService.getById(id);
    }

    @PostMapping
    public ResponseEntity<RoleResponseDto> create(@PathVariable RoleRequestDto dto) {
        RoleResponseDto create = roleService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("/{userId}")
    public RoleResponseDto update(@PathVariable("userId") UUID id,
                                  @PathVariable RoleRequestDto dto) {
        return roleService.update(id, dto);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable("userId") UUID id) {
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
