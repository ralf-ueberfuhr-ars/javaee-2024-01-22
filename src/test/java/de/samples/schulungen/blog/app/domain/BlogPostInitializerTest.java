package de.samples.schulungen.blog.app.domain;

import jakarta.enterprise.inject.Instance;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BlogPostInitializerTest {

  @Test
  void shouldAddWelcomeBlogPostsToService() {
    // Setup / Arrange / Given
    Instance<BlogPost> blogPosts = mock(Instance.class);
    when(blogPosts.stream()).thenReturn(Stream.of(
      BlogPost.builder().build()
    ));
    BlogPostService service = mock(BlogPostService.class);
    BlogPostInitializer sut = new BlogPostInitializer(service, blogPosts);
    when(service.count()).thenReturn(0L);
    // Act / When
    sut.init(new Object());
    // Assert / Then
    verify(service, atLeastOnce()).add(any(BlogPost.class));
  }

  @Test
  void shouldNotAddWelcomeBlogPostsWhenAlreadyExisting() {
    // Setup / Arrange / Given
    Instance<BlogPost> blogPosts = mock(Instance.class);
    when(blogPosts.stream()).thenReturn(Stream.of(
      BlogPost.builder().build()
    ));
    BlogPostService service = mock(BlogPostService.class);
    BlogPostInitializer sut = new BlogPostInitializer(service, blogPosts);
    when(service.count()).thenReturn(1L);
    // Act / When
    sut.init(new Object());
    // Assert / Then
    verify(service, never()).add(any(BlogPost.class));

  }

}
