package com.geddit.geddit.repo;

import com.geddit.geddit.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
  Post findByPostTopic(String postTopic);
}
