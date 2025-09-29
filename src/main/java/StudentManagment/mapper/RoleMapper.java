package StudentManagment.mapper;

import StudentManagment.dto.RoleRequestDto;
import StudentManagment.dto.RoleResponseDto;
import StudentManagment.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleResponseDto toDto(Role role);

    Role toEntity(RoleRequestDto roleRequestDto);
}
