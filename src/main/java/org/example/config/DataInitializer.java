package org.example.config;

import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Insert test data
        userRepository.save(new User("john_doe", "john@example.com", true));
        userRepository.save(new User("jane_smith", "jane@example.com", false));
        userRepository.save(new User("admin", "admin@example.com", true));

        System.out.println("=== Testing queries with JPQL comments ===");

        // Test the queries
        try {
            System.out.println("Users with email: " + userRepository.findUsersWithEmail());
        } catch (Exception e) {
            System.err.println("Query parsing error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

