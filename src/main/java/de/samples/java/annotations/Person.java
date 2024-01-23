package de.samples.java.annotations;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Person {

    private final String name;

    @SayHello(prefix = "This is a person saying:")
    public String sayHello() {
        return "Hello World!";
    }

    @SayHello
    public String sayHelloWithName() {
        return "Hi, I'm " + name + "!";
    }

    public String dontCall() {
        return "bah!";
    }

}
