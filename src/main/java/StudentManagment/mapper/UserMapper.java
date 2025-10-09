package StudentManagment.mapper;

import StudentManagment.dto.req.UserRequestDto;
import StudentManagment.dto.res.UserResponseDto;
import StudentManagment.entity.Role;
import StudentManagment.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface UserMapper {

    UserResponseDto toDto(User user);

    @Mapping(target = "roles", source = "roles")
    @Mapping(target = "password", source = "encode")
    User toEntity(UserRequestDto dto, Set<Role> roles, String encode);

    @Mapping(target = "roles", source = "roleList")
    User updateFromDto(UserRequestDto userRequestDto, Set<Role> roleList, @MappingTarget User user);
}
