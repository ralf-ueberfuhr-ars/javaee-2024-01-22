package de.samples.schulungen.blog.app.domain.interceptors;

import jakarta.enterprise.util.Nonbinding;
import jakarta.interceptor.InterceptorBinding;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.lang.annotation.*;

/**
 * Annotate a method to get an event fired after method execution.
 */
@Inherited
@Documented
@InterceptorBinding
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PublishEvent {

  /**
   * The event class. This class needs a constructor with the same parameters as the method.
   *
   * @return the event class
   */
  @Nonbinding Class<?> value();
  @Nonbinding PublishingMode mode() default PublishingMode.SYNC_AND_ASYNC;

  @RequiredArgsConstructor
  @Getter(AccessLevel.PACKAGE)
  enum PublishingMode {

    ONLY_SYNC(true, false),
    ONLY_ASYNC(false, true),
    SYNC_AND_ASYNC(true, true);

    private final boolean fireSync;
    private final boolean fireAsync;

  }

}
