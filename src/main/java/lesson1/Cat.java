package lesson1;

import java.util.Objects;

import lesson1.Animal;

public class Cat extends Animal {

    public Cat(String name, int maxRunDistance,
               int maxJumpHeight, int maxSwimDistance) {
        super(name, maxRunDistance, maxJumpHeight, maxSwimDistance);
    }

    @Override
    public void voice() {
        System.out.println("Мяу");
    }
}