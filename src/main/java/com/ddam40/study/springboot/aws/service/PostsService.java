package com.ddam40.study.springboot.aws.service;

import com.ddam40.study.springboot.aws.domain.posts.Posts;
import com.ddam40.study.springboot.aws.domain.posts.PostsRepository;
import com.ddam40.study.springboot.aws.web.dto.PostsResponseDto;
import com.ddam40.study.springboot.aws.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;

@RequiredArgsConstructor
@Service
public class PostsService {
  private final PostsRepository postsRepository;

  @Transactional
  public Long save(PostsSaveRequestDto requestDto) {
    return postsRepository.save(requestDto.toEntity()).getId();
  }

  @Transactional
  public Long update(Long id, PostsSaveRequestDto requestDto) {
    Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다. id = " + id));

    posts.update(requestDto.getTitle(), requestDto.getContent());

    return id;
  }

  public PostsResponseDto findById(Long id) {
    Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다. id = " + id));

    return new PostsResponseDto(posts);
  }
}
