package de.samples.schulungen.blog.app;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
//@AllArgsConstructor
@Builder
public class BlogPost {

    private String title;
    private String content;
    private LocalDateTime timestamp;

}
