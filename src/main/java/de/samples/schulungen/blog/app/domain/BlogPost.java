package de.samples.schulungen.blog.app.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
//@AllArgsConstructor
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogPost {

  private UUID id;
  private String title;
  private String content;
  private LocalDateTime timestamp;

}
