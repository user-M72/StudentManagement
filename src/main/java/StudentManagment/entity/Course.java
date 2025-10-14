package StudentManagment.entity;

import StudentManagment.entity.base.BaseDomain;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "courses")
@Getter
@Setter
public class Course extends BaseDomain<UUID> {

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "Course_student_id")
    private Student courseStudent;
}
