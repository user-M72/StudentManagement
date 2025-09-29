package StudentManagment.entity;

import StudentManagment.entity.Enum.RoleEnum;
import StudentManagment.entity.base.BaseDomain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "Roles")
@Getter
@Setter
public class Role extends BaseDomain<UUID> {

    @Column(unique = true)
    private RoleEnum name;
    private String description;

}
