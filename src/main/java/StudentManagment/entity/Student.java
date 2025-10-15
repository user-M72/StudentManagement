package StudentManagment.entity;

import StudentManagment.entity.base.BaseDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "students")
@Getter
@Setter
public class Student extends BaseDomain<UUID> {

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    private String studentId;
    private LocalDate enrollmentDate;
    private Double gpa;
    private String major;

    private Integer year;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Enrollment> enrollments = new HashSet<>();
}
