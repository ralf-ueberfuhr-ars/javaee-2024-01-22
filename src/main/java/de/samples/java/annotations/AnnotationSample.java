package de.samples.java.annotations;

public class AnnotationSample {

    public static void main(String[] args) throws Exception {
        SayHelloFramework framework = new SayHelloFramework();
        Person person = new Person("Max");
        framework.executeSayHello(person);
    }

}
