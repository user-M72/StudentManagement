package StudentManagment.config;

import StudentManagment.entity.Course;
import StudentManagment.entity.Enum.RoleEnum;
import StudentManagment.entity.Role;
import StudentManagment.entity.User;
import StudentManagment.repository.CourseRepository;
import StudentManagment.repository.RoleRepository;
import StudentManagment.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Set;

@Configuration
@AllArgsConstructor
public class DataInitializer {

    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initRoleAdmin(RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.findByName(RoleEnum.ADMIN).isEmpty()) {
                Role roleAdmin = new Role();
                roleAdmin.setName(RoleEnum.ADMIN);
                roleAdmin.setDescription("administrator");
                roleRepository.save(roleAdmin);
            }

            if (roleRepository.findByName(RoleEnum.TEACHER).isEmpty()) {
                Role teacherRole = new Role();
                teacherRole.setName(RoleEnum.TEACHER);
                teacherRole.setDescription("Teach student");
                roleRepository.save(teacherRole);
            }

            if (roleRepository.findByName(RoleEnum.STUDENT).isEmpty()) {
                Role studentRole = new Role();
                studentRole.setName(RoleEnum.STUDENT);
                studentRole.setDescription("Hard working, engaged");
                roleRepository.save(studentRole);
            }
        };
    }

    @Bean
    public CommandLineRunner initCourses(CourseRepository courseRepository) {
        return args -> {
            if (courseRepository.count() == 0) {

                Course math = new Course();
                math.setTitle("Mathematics");
                math.setDescription("Learn algebra and geometry");

                Course physics = new Course();
                physics.setTitle("Physics");
                physics.setDescription("Mechanics and thermodynamics");

                Course programming = new Course();
                programming.setTitle("Programming");
                programming.setDescription("Java and Spring Boot");

                courseRepository.saveAll(List.of(math, physics, programming));
            }
        };
    }

    @Bean
    public CommandLineRunner initAdminUser(RoleRepository roleRepository, UserRepository userRepository) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {

                // Проверяем, есть ли роль ADMIN
                Role adminRole = roleRepository.findByName(RoleEnum.ADMIN)
                        .orElseGet(() -> {
                            Role role = new Role();
                            role.setName(RoleEnum.ADMIN);
                            return roleRepository.save(role);
                        });

                // Создаём админа
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin"));
                admin.setEmail("admin@example.com");
                admin.setRoles(Set.of(adminRole));

                userRepository.save(admin);
                System.out.println("✅ Admin user created: username=admin, password=admin");
            }
        };
    }
}
