package com.example.vacayday.backend.config;




import com.example.vacayday.backend.entity.Role;
import com.example.vacayday.backend.entity.User;
import com.example.vacayday.backend.service.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {

        if (userRepository.count() == 0) {

            User admin = new User();
            admin.setVorname("Admin");
            admin.setNachname("User");
            admin.setUsername("admin");
            admin.setPassword("admin"); // nur zum Testen!
            admin.setRole(Role.ADMIN);

            userRepository.save(admin);

            System.out.println(">>> Default admin created: admin / admin");
        }
    }
}