package StudentManagment.entity;

import StudentManagment.entity.Enum.RoleEnum;
import StudentManagment.entity.base.BaseDomain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "Roles")
@Getter
@Setter
public class Role extends BaseDomain<UUID> {

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private RoleEnum name;
    private String description;

}
