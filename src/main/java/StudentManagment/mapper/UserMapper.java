package StudentManagment.mapper;

import StudentManagment.dto.req.UserRequestDto;
import StudentManagment.dto.res.UserResponseDto;
import StudentManagment.entity.Role;
import StudentManagment.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto toDto(User user);

    User toEntity(UserRequestDto dto, Set<Role> roles, String encode);

    User updateFromDto(UserRequestDto userRequestDto, Set<Role> roleList, @MappingTarget User user);
}
