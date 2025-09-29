package StudentManagment.mapper;

import StudentManagment.dto.UserRequestDto;
import StudentManagment.dto.UserResponseDto;
import StudentManagment.entity.Role;
import StudentManagment.entity.User;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto toDto(User user);
    User toEntity(UserResponseDto dto);

    User toEntity(UserRequestDto userRequestDto, Set<Role> roleList, String encode);
}
