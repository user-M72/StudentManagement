package StudentManagment.service;

import StudentManagment.dto.UserRequestDto;
import StudentManagment.dto.UserResponseDto;
import StudentManagment.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserResponseDto> get();

    UserResponseDto getById(UUID id);

    UserResponseDto create(UserRequestDto userRequestDto);

    UserResponseDto update(UUID id, UserRequestDto userRequestDto);

    void delete(UUID id);


}
