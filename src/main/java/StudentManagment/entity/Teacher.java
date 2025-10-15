package StudentManagment.entity;

import StudentManagment.entity.base.BaseDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "teachers")
@Getter
@Setter
public class Teacher extends BaseDomain<UUID> {

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false,unique = true)
    private User user;

    private String employeeId;
    private String specialization;
    private LocalDateTime hireDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();

}
