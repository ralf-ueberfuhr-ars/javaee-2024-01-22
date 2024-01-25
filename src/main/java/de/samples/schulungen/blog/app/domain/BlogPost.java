package de.samples.schulungen.blog.app.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
//@AllArgsConstructor
@Builder
public class BlogPost {

  private UUID id;
  @NotNull
  @Size(min = 3)
  private String title;
  @Size(min = 10)
  private String content;
  private LocalDateTime timestamp;

}
