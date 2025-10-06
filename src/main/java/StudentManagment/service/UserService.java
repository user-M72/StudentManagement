package StudentManagment.service;

import StudentManagment.dto.req.UserRequestDto;
import StudentManagment.dto.res.UserResponseDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserResponseDto> get();

    UserResponseDto getById(UUID id);

    UserResponseDto create(UserRequestDto userRequestDto);

    UserResponseDto update(UUID id, UserRequestDto userRequestDto);

    void delete(UUID id);


}
