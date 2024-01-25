package de.samples.schulungen.blog.app.boundary.jsf;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIViewRoot;
import jakarta.faces.context.FacesContext;

import java.util.Optional;

@ApplicationScoped
public class JsfComponentTree {

  public UIViewRoot getViewRoot() {
    return FacesContext.getCurrentInstance().getViewRoot();
  }

  public <T extends UIComponent> Optional<T> findComponent(String id, Class<T> componentType) {
    return Optional
      .ofNullable(getViewRoot().findComponent(id))
      .map(componentType::cast);
  }

}
