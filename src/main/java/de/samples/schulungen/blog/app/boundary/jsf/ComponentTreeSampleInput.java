package de.samples.schulungen.blog.app.boundary.jsf;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@RequestScoped
@Named("componentTreeSampleInput")
@Getter
@Setter
public class ComponentTreeSampleInput {

  private LocalDate startDate;
  private LocalDate endDate;

}
