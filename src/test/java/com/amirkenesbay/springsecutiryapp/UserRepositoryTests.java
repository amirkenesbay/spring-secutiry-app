package com.amirkenesbay.springsecutiryapp;

import com.amirkenesbay.springsecutiryapp.entity.User;
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
    private UserService userService;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("amirkenesbay@gmail.com");
        user.setPassword("Supa1807");
        user.setFirstName("Amir");
        user.setLastName("Kenesbay");

        User savedUser = userService.saveUser(user);
        User existUser = entityManager.find(User.class, savedUser.getId());
        Assertions.assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }
}

