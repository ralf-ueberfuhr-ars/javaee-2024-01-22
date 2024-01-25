package de.samples.schulungen.blog.app.boundary.jsf;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.html.HtmlOutputText;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Period;

@RequestScoped
@Named("componentTreeSampleBackingBean")
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ComponentTreeSampleBackingBean {

  @Getter
  private final TwoDateFieldsValidator dateFieldsValidator = new TwoDateFieldsValidator();
  private final ComponentTreeSampleInput input;
  private final JsfComponentTree tree;

  // component binding would also be possible

  protected HtmlOutputText getTxtResult() {
    return tree
      .findComponent("txtResult", HtmlOutputText.class)
      .orElseThrow(NullPointerException::new);
  }

  public void calculate() {
    final var period = Period.between(
      input.getStartDate(),
      input.getEndDate()
    );
    getTxtResult().setValue(period.getDays());
  }


}
