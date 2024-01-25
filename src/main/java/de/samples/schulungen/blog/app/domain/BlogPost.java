package de.samples.schulungen.blog.app.domain;

import jakarta.enterprise.inject.Alternative;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
  @NotNull
  @Size(min = 3)
  private String title;
  @Size(min = 10)
  private String content;
  private LocalDateTime timestamp;

}
