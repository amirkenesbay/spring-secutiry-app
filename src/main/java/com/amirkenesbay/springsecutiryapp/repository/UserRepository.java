package com.amirkenesbay.springsecutiryapp.repository;

import com.amirkenesbay.springsecutiryapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
