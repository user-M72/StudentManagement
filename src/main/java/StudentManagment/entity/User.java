package StudentManagment.entity;

import StudentManagment.entity.base.BaseDomain;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "Users")
@Getter
@Setter
public class User extends BaseDomain<UUID>{

    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private String password;


    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinTable(name = "user_id"),
            inverseJoinColumns = @JoinTable(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
}
