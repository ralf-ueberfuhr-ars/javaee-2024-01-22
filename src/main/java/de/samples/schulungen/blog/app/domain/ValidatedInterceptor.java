package de.samples.schulungen.blog.app.domain;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import java.util.Set;
import java.util.stream.Stream;

@Validated
@Interceptor
public class ValidatedInterceptor {

  @Inject
  Validator validator;

  @AroundInvoke
  public Object validateMethodParameters(InvocationContext ic) throws Exception {
    final var paramAnnotations = ic.getMethod().getParameterAnnotations();
    final var paramValues = ic.getParameters();
    for (int i = 0; i < paramAnnotations.length; i++) {
      boolean shouldValidate = Stream.of(paramAnnotations[i])
        .anyMatch(Valid.class::isInstance);
      if (shouldValidate) {
        Set<ConstraintViolation<Object>> violations = validator.validate(paramValues[i]);
        if (!violations.isEmpty()) {
          throw new ConstraintViolationException(violations);
        }
      }
    }
    return ic.proceed();
  }

}
