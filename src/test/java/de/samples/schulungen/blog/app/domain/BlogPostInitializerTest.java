package de.samples.schulungen.blog.app.domain;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BlogPostInitializerTest {

  @Test
  void shouldAddWelcomeBlogPostsToService() {
    // Setup / Arrange / Given
    BlogPostService service = mock(BlogPostService.class);
    BlogPostInitializer sut = new BlogPostInitializer();
    sut.service = service;
    when(service.count()).thenReturn(0L);
    // Act / When
    sut.init(new Object());
    // Assert / Then
    verify(service, atLeastOnce()).add(any(BlogPost.class));
  }

  @Test
  void shouldNotAddWelcomeBlogPostsWhenAlreadyExisting() {
    // Setup / Arrange / Given
    BlogPostService service = mock(BlogPostService.class);
    BlogPostInitializer sut = new BlogPostInitializer();
    sut.service = service;
    when(service.count()).thenReturn(1L);
    // Act / When
    sut.init(new Object());
    // Assert / Then
    verify(service, never()).add(any(BlogPost.class));

  }

}
