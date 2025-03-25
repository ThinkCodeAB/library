package se.thinkcode.recursion;

public record Person(Person far,
                     Person mor,
                     String barn) {
}
