package de.samples.schulungen.blog.app.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
//@AllArgsConstructor
@Builder
public class BlogPost {

  private UUID id;
  private String title;
  private String content;
  private LocalDateTime timestamp;

}
