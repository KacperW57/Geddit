package com.geddit.geddit.service;

import com.geddit.geddit.model.Post;
import java.util.Collection;

public interface PostService {
  Post create(Post post);
  Collection<Post> list(int limit);
  Post get(Long id);
  Post update(Post post);
  Boolean delete(long id);
}
