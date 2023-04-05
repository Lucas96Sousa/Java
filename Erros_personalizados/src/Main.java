import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {
  public static void main(String[] args) throws ParseExpection {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.print("Room number: ");
    int number = sc.nextInt();
    System.out.print("Check-in date (dd/MM/yyyy): ");
    Date checkIn = sdf.parse(sc.next());

  }
}
