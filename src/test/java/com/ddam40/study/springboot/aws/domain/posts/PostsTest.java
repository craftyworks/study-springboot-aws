package com.ddam40.study.springboot.aws.domain.posts;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostsTest {
  @Test
  public void 롬복_기능_테스트() {
    //given
    String author = "Tom";
    String title = "Test";
    String content = "Contents";

    //when
    Posts posts = Posts.builder().author(author).title(title).content(content).build();

    //then
    assertThat(posts.getAuthor()).isEqualTo(author);
    assertThat(posts.getTitle()).isEqualTo(title);
    assertThat(posts.getContent()).isEqualTo(content);
  }
}
