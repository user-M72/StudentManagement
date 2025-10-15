package StudentManagment.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "departments")
@Getter
@Setter
public class Department {

    private String name;
    private String code;

    private String description;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();


    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Teacher> teachers = new HashSet<>();
}
