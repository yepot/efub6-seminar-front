package com.efub.frontSeminar.post.repository;

import com.efub.frontSeminar.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}