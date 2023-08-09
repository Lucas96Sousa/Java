package com.stellarviewer.proj.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.stellarviewer.proj.entities.Category;
import com.stellarviewer.proj.entities.Order;
import com.stellarviewer.proj.entities.User;
import com.stellarviewer.proj.entities.enums.OrderStatus;
import com.stellarviewer.proj.repositories.CategoryRepository;
import com.stellarviewer.proj.repositories.OrderRepository;
import com.stellarviewer.proj.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        // Category
        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        // User
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "99985423266", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "99985424343", "123456");

        // Order
        Order o1 = new Order(null, Instant.parse("2023-06-20T21:22:00Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2023-04-10T03:04:02Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2023-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }

}
