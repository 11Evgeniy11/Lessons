package lesson6;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeWorkApp {
    public static void main(String[] args) throws InputMismatchException {

        Scanner scanner = new Scanner(System.in);

        double distanceRun = 200;
        double distanceSwim =  0;
        Cat cat = new Cat(distanceRun, distanceSwim);

        distanceRun = 500;
        distanceSwim = 10;
        Animal dog = new Dog(distanceRun, distanceSwim);


        System.out.println("Кошка может пробежать: " + cat.getAnimalDistanceRun() +
                " м. \nСобака может пробежать: " + dog.getAnimalDistanceRun() + " м.");

        System.out.println("Введите дистанцию для бега:");
        double distance = scanner.nextDouble();

        System.out.println("Кошка пробежала(" + distance + ")" + cat.run(distance));
        System.out.println("Собака пробежала(" + distance + ")" + dog.run(distance));
        System.out.println("\n****************\n");


        System.out.println("Кошка может проплыть: " + cat.getAnimalDistanceSwim() +
                " м. \nСобака может проплыть: " + dog.getAnimalDistanceSwim() + " м.");

        System.out.println("Введите дистанцию для плавания:");
        distance = scanner.nextDouble();

        System.out.println("Кошка проплыла(" + distance + ")"+ cat.swim(distance));
        System.out.println("Собака проплыла(" + distance + ")"+ dog.swim(distance));

    }

}

class Cat extends Animal {

        Cat(double animalDistanceRun, double animalDistanceSwim) {
            super(animalDistanceRun, animalDistanceSwim);
        }
    }
    class Dog extends Animal {

        Dog(double animalDistanceRun, double animalDistanceSwim) {
            super(animalDistanceRun, animalDistanceSwim);
        }
    }


