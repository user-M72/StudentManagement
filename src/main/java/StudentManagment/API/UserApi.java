package StudentManagment.API;

import StudentManagment.dto.req.UserRequestDto;
import StudentManagment.dto.res.UserResponseDto;
import StudentManagment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/users/v1")
public class UserApi {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserResponseDto> get() {
        return userService.get();
    }

    @GetMapping("/{userId}")
    public UserResponseDto getById(@PathVariable("userId") UUID id) {
        return userService.getById(id);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto dto) {
        UserResponseDto create = userService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("{userId}")
    public UserResponseDto update(@PathVariable("userId") UUID id,
                                  @RequestBody UserRequestDto dto) {
        return userService.update(id, dto);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable("userId") UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
