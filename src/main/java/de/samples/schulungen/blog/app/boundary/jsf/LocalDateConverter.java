package de.samples.schulungen.blog.app.boundary.jsf;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@FacesConverter(forClass = LocalDate.class)
public class LocalDateConverter implements Converter<LocalDate> {

  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  @Override
  public LocalDate getAsObject(FacesContext context, UIComponent component, String value) {
    return null == value || value.isEmpty() ? null : LocalDate.parse(value, formatter);
  }

  @Override
  public String getAsString(FacesContext context, UIComponent component, LocalDate value) {
    return null == value ? null : value.format(formatter);
  }

}
