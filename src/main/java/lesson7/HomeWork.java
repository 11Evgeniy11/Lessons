package lesson7;
import java.util.Scanner;
public class HomeWork {
  public static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    int action;
    Cat[] allCats = new Cat[4];
    allCats[0] = new Cat("Барсик", 5, false);
    allCats[1] = new Cat("Снежок", 30, false);
    allCats[2] = new Cat("Мурзик", 10, false);
    allCats[3] = new Cat("Чернышка", 45, false);


    plate plate = new plate(50);
    plate.info();
    for (int i = 0; i < allCats.length; i++) {
      if (allCats[i].fullness == false && allCats[i].appetite < plate.food){
        allCats[i].eat(plate);
        allCats[i].fullness = true;
        System.out.println("Котик " + allCats[i].name + " покушал!");
      } else {
        System.out.println("Котик " + allCats[i].name + " не поел!");
      }
    }
    plate.info();
    System.out.println("Сколько грамм вискаса добавить еще в миску?");
    action = sc.nextInt();
    plate.increaseFood(action);
    plate.info();

  }

}
class plate {
  public int food;

  public plate(int food) {
    this.food = food;
  }

  public void decreaseFood(int n) {
    food -= n;
  }

  public void increaseFood(int x) {
    food += x;
  }

  public void info() {
    System.out.println("Всего еды: " + food);
  }
}



