package lesson1;

import lesson1.Animal;
import lesson1.Cat;
import lesson1.Wolf;
import lesson1.obstacles.Obstacle;


public class Team {
    private String name;// название команды
    private Participant participants[] ;    // участники

    public Team(String name) {
        this.name = name;
    }

    public Team(String name,Participant ... participantsGiven ) {
        this.name = name;
        this.participants = participantsGiven;
    }

    public void getTeamInfo() {
        System.out.println("Команда: " + this.name );
        for (Participant participant : participants) {
            if (participant instanceof Wolf) {
                System.out.println("Волк " + participant.getName());
            }
            if (participant instanceof Cat) {
                System.out.println("Кот " + participant.getName());
            }
            if (participant instanceof Turtle) {
                System.out.println("Черепаха " + participant.getName());
            }
        }
    }

    public void showResults(){
        for (Participant participant : participants) {
            //obstacle.doIt(participant);
            if (!participant.isOnDistance()) {
                break;
            }
        }
    }
    public void doIt(Obstacle obstacle){
        for (Participant participant : participants) {
            obstacle.doIt(participant);
            /*if (!participant.isOnDistance()) {
                break;
            }*/
        }
    }



}