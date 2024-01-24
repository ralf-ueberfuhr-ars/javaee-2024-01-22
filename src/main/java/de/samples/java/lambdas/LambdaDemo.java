package de.samples.java.lambdas;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaDemo {

  private static double add(double summand1, double summand2) {
    return summand1 + summand2;
  }

  private static double add2() {
    double sum = 0d;
    while(sum <= 10) {
      sum += Math.random();
    }
    return sum;
  }

  // Funktionales Interface: Interface mit 1(!) abstrakten Methode
  @FunctionalInterface
  private interface NumberGenerator {
    double generateNumber();
  }

  private static double add3(NumberGenerator generator) {
    double sum = 0d;
    while(sum <= 10) {
      sum += generator.generateNumber();
    }
    return sum;
  }

  public static void main(String[] args) {
    // Addiere 2 Zahlen
    System.out.println(add(3.5, 1.2));
    // Addiere 2 Zufallszahlen
    System.out.println(add(Math.random(), Math.random()));
    // Addiere Zufallszahlen solange, bis die Summe > 10 ist
    System.out.println(add2());
    // Entscheidung, dass Math.random() verwendet werden soll, MUSS in main bleiben
    System.out.println(add3(new NumberGenerator() {
      @Override
      public double generateNumber() {
        return Math.random();
      }
    }));
    // Syntaktische Kürzung durch Type Inference
    System.out.println(add3(/*new NumberGenerator() {
      @Override
      public double generateNumber*/() -> {
        return Math.random();
      }
    /*}*/));
    System.out.println(add3(() -> {
        return Math.random();
      }
    ));
    // Spezialfall: nur 1 Anweisung
    System.out.println(add3( () -> Math.random() ));
    // Spezialfall: Parameter matchen: ()
    System.out.println(add3( Math::random ));

    System.out.println(add3( () -> 0.35 ));

    // Anwendungsfall: Streams
    Collection<String> namen = Arrays.asList("Werner", "Bianca", "Martin", "Jochen", "Daniel-Benjamin", "Johannes", "Ralf");
    {
      Collection<String> kurznamen = new LinkedList<>();
      for (String name : namen) {
        if(name.length()<=6) {
          kurznamen.add(name.toUpperCase());
        }
      }
      System.out.println(kurznamen);
    }
    {
      Collection<String> kurznamen = namen.stream()
        .filter(name -> name.length()<=6)
        .map(String::toUpperCase)
        .collect(Collectors.toList());
      System.out.println(kurznamen);
    }

  }

}
