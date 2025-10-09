package StudentManagment.mapper;

import StudentManagment.dto.req.RoleRequestDto;
import StudentManagment.dto.res.RoleResponseDto;
import StudentManagment.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {
    RoleResponseDto toDto(Role role);

    Role toEntity(RoleRequestDto roleRequestDto);

    @Mapping(target = "id", ignore = true)
    void updateFromDto(RoleRequestDto roleRequestDto, @MappingTarget Role role);
}
