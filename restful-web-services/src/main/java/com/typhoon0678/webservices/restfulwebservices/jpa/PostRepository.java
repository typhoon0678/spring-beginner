package com.typhoon0678.webservices.restfulwebservices.jpa;

import com.typhoon0678.webservices.restfulwebservices.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
