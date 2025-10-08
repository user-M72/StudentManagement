package StudentManagment.config;

import StudentManagment.entity.Enum.RoleEnum;
import StudentManagment.entity.Role;
import StudentManagment.entity.User;
import StudentManagment.repository.RoleRepository;
import StudentManagment.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
@AllArgsConstructor
public class DataInitializer {

    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initAdminUser(RoleRepository roleRepository, UserRepository userRepository){
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
