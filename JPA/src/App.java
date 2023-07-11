import domain.Person;

public class App {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person(1, "Carlos da Silva", "carlos@gmail.com");
        Person p2 = new Person(2, "Joaquim Phoenix", "joaquim@gmail.com");
        Person p3 = new Person(3, "Javier Barden", "javier@gmail.com");

        System.out.println(p1);
        System.out.println("\n" + p2);
        System.out.println("\n" + p3);
    }
}
