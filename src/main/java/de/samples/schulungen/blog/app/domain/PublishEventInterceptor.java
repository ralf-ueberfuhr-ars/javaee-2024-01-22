package de.samples.schulungen.blog.app.domain;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@PublishEvent(Object.class)
@Interceptor
public class PublishEventInterceptor {

  @AroundInvoke
  public Object publishEvent(InvocationContext ic) throws Exception {

    return ic.proceed();

  }

  }
