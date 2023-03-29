package com.geddit.geddit.resource;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.geddit.geddit.model.Post;
import com.geddit.geddit.model.Response;
import com.geddit.geddit.service.implementation.PostServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostResource {

  private final PostServiceImpl postService;

  @GetMapping("/list")
  public ResponseEntity<Response> getPosts() throws InterruptedException {
    return ResponseEntity.ok(
      Response
        .builder()
        .timeStamp(now())
        .data(of("posts", postService.list(30)))
        .message("Posts retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
  }

  @PostMapping("/save")
  public ResponseEntity<Response> savePost(@RequestBody @Valid Post post) {
    return ResponseEntity.ok(
      Response
        .builder()
        .timeStamp(now())
        .data(of("posts", postService.create(post)))
        .message("Post created")
        .status(CREATED)
        .statusCode(CREATED.value())
        .build()
    );
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<Response> getPost(@PathVariable("id") Long id) {
    return ResponseEntity.ok(
      Response
        .builder()
        .timeStamp(now())
        .data(of("posts", postService.get(id)))
        .message("Server retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Response> deletePost(@PathVariable("id") Long id) {
    return ResponseEntity.ok(
      Response
        .builder()
        .timeStamp(now())
        .data(of("deleted", postService.delete(id)))
        .message("Post deleted")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
  }
}
