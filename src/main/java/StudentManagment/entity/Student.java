package StudentManagment.entity;

import StudentManagment.entity.base.BaseDomain;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "students")
@Getter
@Setter
public class Student extends BaseDomain<UUID> {

    private String name;
    private String phone;
    private String email;


}
