package StudentManagment.entity;

import StudentManagment.entity.base.BaseDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "users")
@Getter
@Setter
public class User extends BaseDomain<UUID> {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private Student student;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Teacher teacher;

}
