package com.geddit.geddit.service.implementation;

import com.geddit.geddit.model.Post;
import com.geddit.geddit.repo.PostRepo;
import com.geddit.geddit.service.PostService;
import jakarta.transaction.Transactional;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class PostServiceImpl implements PostService {

  private final PostRepo postRepo;

  @Override
  public Post create(Post post) {
    log.info("Saving new post: {}", post.getPostTopic());
    return postRepo.save(post);
  }

  @Override
  public Collection<Post> list(int limit) {
    log.info("Fetching all posts");
    return postRepo.findAll(PageRequest.of(0, limit)).toList();
  }

  @Override
  public Post get(Long id) {
    log.info("Fetching post by id: {}", id);
    return postRepo.findById(id).get();
  }

  @Override
  public Post update(Post post) {
    log.info("Updating post : {}", post.getPostTopic());
    return postRepo.save(post);
  }

  @Override
  public Boolean delete(long id) {
    log.info("Deleting post by id: {}", id);
    postRepo.deleteById(id);
    return true;
  }
}
