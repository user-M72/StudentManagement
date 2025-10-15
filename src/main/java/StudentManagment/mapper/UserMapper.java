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


    User toEntity(UserRequestDto dto);


    User updateFromDto(UserRequestDto userRequestDto, Set<Role> roleList, @MappingTarget User user);

}
