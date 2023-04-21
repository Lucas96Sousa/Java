import devices.ComboDevice;
import devices.ConcretePrinter;
import devices.ConcreteScanner;

public class Main {
   public static void main(String[] args) {
      ConcretePrinter p = new ConcretePrinter("1080");
      p.processDoc("My Letter");
      p.print("My Letter");

      System.out.println();
      ConcreteScanner sc = new ConcreteScanner("2003");
      sc.processDoc("My Email");
      System.out.println("Scan result: " + sc.scan());

      System.out.println();
      ComboDevice c = new ComboDevice("1255");
      c.processDoc("My dissertation");
      c.print("My dissertation");
      System.out.println("Scan result: " + c.scan());
   }
}
