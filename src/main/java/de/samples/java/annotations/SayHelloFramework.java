package de.samples.java.annotations;

import java.lang.reflect.Method;

public class SayHelloFramework {
    public void executeSayHello(Object objectWithPotentialAnnotations) throws Exception {
        
        // Reflection API

        Class<?> clazz = objectWithPotentialAnnotations.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for(Method methodToInvoke : methods) {
            SayHello annotation = methodToInvoke.getAnnotation(SayHello.class);
            if(annotation != null) {
                String prefix = annotation.prefix();
                if(!prefix.isEmpty()) {
                    System.out.println(prefix);
                }
                System.out.println(methodToInvoke.invoke(objectWithPotentialAnnotations));
            }
        }


    }
}
