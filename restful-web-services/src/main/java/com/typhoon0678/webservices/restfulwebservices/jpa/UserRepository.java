package com.typhoon0678.webservices.restfulwebservices.jpa;

import com.typhoon0678.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
