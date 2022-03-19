package com.amirkenesbay.springsecutiryapp;

import com.amirkenesbay.springsecutiryapp.entity.User;
import com.amirkenesbay.springsecutiryapp.repository.UserRepository;
import com.amirkenesbay.springsecutiryapp.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("amirkenesbay@gmail.com");
        user.setPassword("amirkenesbay1807");
        user.setFirstName("Amir");
        user.setLastName("Kenesbay");

        User savedUser = userRepository.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());
        Assertions.assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testFindUserByEmail(){
        String email = "amirkenesbay@gmail.com";
        User user = userRepository.findByEmail(email);
        Assertions.assertThat(user).isNotNull();
    }
}

