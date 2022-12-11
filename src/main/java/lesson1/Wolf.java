package lesson1;
import lesson1.Animal;

public class Wolf extends Animal {

    public Wolf(String name, int maxRunDistance,
               int maxJumpHeight, int maxSwimDistance) {
        super(name, maxRunDistance, maxJumpHeight, maxSwimDistance);
    }

    @Override
    public void voice() {
        System.out.println("АУУУ!");
    }

    public void swim() {
        System.out.println(getName() + " плывет");
    }
}
