package lesson5;

public class HomeWorkApp {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Petrova Elizaveta", "Engineer", "elizpet@mail.ru", "88005553535",50000,33);
        persArray[1] = new Person("Kuzkin Alexadr", "Manager", "alex666@mail.ru", "88005553535",50000,44);
        persArray[2] = new Person("Ivanov Pavel", "leader", "ivanov@mail.ru", "88005553535",70000,55);
        persArray[3] = new Person("Kuzmichova Olga", "secretary", "kuzmich@mail.ru", "880055535356",10000,18);
        persArray[4] = new Person("Bond James", "director", "bond777@mail.ru", "88005553535",100000,60);
        for (Person employee : persArray)
            if (employee.getAge()>40)
                System.out.println(employee);

    }
}
class Person {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }




    public int getAge() {
        return age;
    }
    @Override
    public String toString(){
        return("\nName: " +name+ "\nposition: "
                +position+ "\nemail: "
                +email+ "\nphone: "
                +phone+ "\nsalary: "
                +salary+ "\nage: "
                +age);
    }
}
