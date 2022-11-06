package lesson2;

public class HomeWorkApp {

    public static void main(String[] args) {
        System.out.println("Задание1");
        System.out.println(within10and20(10, 3));
        System.out.println("Задание2");
        isPositiveOrNegative(-10);
        System.out.println("Задание3");
        System.out.println(isNegative(3));
        System.out.println("Задание4");
        printWordAndNumber("test", 3);

    }

    static boolean within10and20(int x, int y) {
        int sum = x + y;
        if (sum >= 10 && sum <= 20) return true;
        else return false;
    }

    static void isPositiveOrNegative(int x) {
        if (x >= 0) {
            System.out.println("Число положительное");
        }
        else System.out.println("Число отрицательное");
    }

    static boolean isNegative(int x) {
      if (x < 0) return true;
      else return false;
    }

    static void printWordAndNumber(String word, int times) {
        for (int x = 0; x < times; x++) {
    System.out.println(word);
        }
    }

}

