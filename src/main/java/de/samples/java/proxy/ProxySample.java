package de.samples.java.proxy;

import java.lang.reflect.Proxy;

public class ProxySample {

  private static interface Person {
    void sayHello();
  }

  public static void main(String[] args) {

    final Person original = new Person() {
      @Override
      public void sayHello() {
        System.out.println("Hallo Welt");
      }
    };

    Person person = (Person) Proxy.newProxyInstance(
      ProxySample.class.getClassLoader(),
      new Class[]{Person.class},
      (proxy, method, parameters) -> {
        System.out.println(method.getName());
        if("sayHello".equals(method.getName()) && method.getParameterTypes().length == 0) {
          original.sayHello();
          return null;
        }
        if("hashCode".equals(method.getName()) && method.getParameterTypes().length == 0) {
          return 0;
        }
        return null;
      }
    );

    person.sayHello();
    System.out.println(person.toString());
    System.out.println(person.hashCode());


  }

}
