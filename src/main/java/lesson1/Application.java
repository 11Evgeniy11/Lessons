package lesson1;
import lesson1.Cat;
import lesson1.Wolf;
import lesson1.obstacles.*;

public class Application {

    public static void main(String[] args) {

        Course c = new Course(new Obstacle[] {
                new Cross(5),
                new Wall(3),
                new Water(7)
        });
        Team team = new Team("Союз",
                new Cat("Барсик", 10, 12, 0),
                new Wolf("Бегун", 20, 5, 15),
                new Cat("Мурзик", 9, 14, 0),
                new Turtle("Чермандер", 50, 50, 50));
        team.getTeamInfo();

        c.doIt(team);
        team.showResults();

    }
}
