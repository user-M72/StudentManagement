package StudentManagment.entity;

import StudentManagment.entity.base.BaseDomain;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "students")
@Getter
@Setter
public class Student extends BaseDomain<UUID> {

    private String name;
    private String phone;
    private String email;

    @ManyToMany
    @JoinTable(
            name = "student_courses", // 👈 имя таблицы связи
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();

}
