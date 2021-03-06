package com.ddam40.study.springboot.aws.web;

import com.ddam40.study.springboot.aws.service.PostsService;
import com.ddam40.study.springboot.aws.web.dto.PostsResponseDto;
import com.ddam40.study.springboot.aws.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {
  private final PostsService postsService;

  @PostMapping("/api/v1/posts")
  public Long save(@RequestBody PostsSaveRequestDto requestDto) {
    return postsService.save(requestDto);
  }

  @PutMapping("/api/v1/posts/{id}")
  public Long update(@PathVariable Long id, @RequestBody PostsSaveRequestDto requestDto) {
    return postsService.update(id, requestDto);
  }

  @GetMapping("/api/v1/posts/{id}")
  public PostsResponseDto findById(@PathVariable Long id) {
    return postsService.findById(id);
  }
}
