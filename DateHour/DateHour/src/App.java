import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;

public class App {
    public static void main(String[] args) throws Exception {

        //*! Trabalhando com date formats */

        // DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // LocalDate d01 = LocalDate.now();
        
        // LocalDateTime d02 = LocalDateTime.now();
        
        // Instant d03 = Instant.now();

        // LocalDate d04 = LocalDate.parse("2023-01-16");

        // LocalDateTime d05 = LocalDateTime.parse("2023-01-16T11:05:25");

        // Instant d06 = Instant.parse("2023-01-16T11:07:30Z");

        // Instant d07 = Instant.parse("2023-01-16T11:07:30-03:00");

        // LocalDate d08 = LocalDate.parse("16/01/2023", fmt1);


        // System.out.println("d01 = " +d01);

        // System.out.println("d02 = " + d02);

        // System.out.println("d03 = " + d03);

        // System.out.println("d04 = " + d04);

        // System.out.println("d05 = " + d05);

        // System.out.println("d06 = " + d06);

        // System.out.println("d07 = " + d07);

        // System.out.println("d08 = " + d08);



        // //*! Convertendo data para Texto */

        LocalDate d01 = LocalDate.parse("2023-01-16");
        LocalDateTime d02 = LocalDateTime.parse("2023-01-16T11:20:12");
        Instant d03 = Instant.parse("2023-01-16T11:20:39Z");

        // // Formantando de forma customizada
        // DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        // DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        // DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME; //*!Not used */
        // DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;

        // System.out.println("d01 = " + fmt1.format(d01));
        // System.out.println("d02 = "+ fmt2.format(d02));
        // System.out.println("d03 = "+ fmt3.format(d03));

        // System.out.println("d04 = " + fmt3.format(d03));
        // System.out.println("d05 = " + fmt5.format(d03));



                //*!Convertendo data-hora global para local */
    // LocalDate d01 = LocalDate.parse("2023-01-16");
    // LocalDateTime d02 = LocalDateTime.parse("2023-01-16T11:20:12");
    // Instant d03 = Instant.parse("2023-01-16T11:20:39Z");

    // LocalDate r1 = LocalDate.ofInstant(d03, ZoneId.systemDefault());
    // LocalDate r2 = LocalDate.ofInstant(d03, ZoneId.of("Japan"));
    // LocalDateTime r3 = LocalDateTime.ofInstant(d03, ZoneId.systemDefault());
    // LocalDateTime r4 = LocalDateTime.ofInstant(d03, ZoneId.of("Japan"));

    // System.out.println("r1 = " + r1);
    // System.out.println("r2 = " + r2);

    // System.out.println("r3 = " + r3);
    // System.out.println("r4 =" + r4);

    // System.out.println("d01 day = " + d01.getDayOfMonth());
    // System.out.println("d01 month = " + d01.getMonthValue());
    // System.out.println("d01 year =" + d01.getYear());


    // System.out.println("d02  hour = " + d02.getHour());
    // System.out.println("d02  minute = " + d02.getMinute());
    // System.out.println("d02  seconds = " + d02.getSecond());

                    //*! Calculo com horários */
    
    LocalDate pastWeek = d01.minusDays(7);
    LocalDate nextWeek = d01.plusDays(7);

    System.out.println("pastWeek = " +pastWeek);
    System.out.println("nextWeek = " +nextWeek);


    LocalDateTime pastWeekTime = d02.minusDays(7);
    LocalDateTime nextWeekTime = d02.plusDays(7);

    System.out.println("pastWeekTime = " + pastWeekTime);
    System.out.println("nextWeekTime = " + nextWeekTime);

    Instant pastWeekInstant = d03.minus(6, ChronoUnit.DAYS);
    Instant nextWeekInstant = d03.plus(16, ChronoUnit.DAYS);

    System.out.println("pastWeekInstant = " + pastWeekInstant);
    System.out.println("nextWeekInstant = " + nextWeekInstant);

    Duration t1 = Duration.between(pastWeek.atTime(0,0), d01.atStartOfDay());
    Duration t2 = Duration.between(pastWeekTime, d02);
    Duration t3 = Duration.between(pastWeekInstant, d03);
    Duration t4 = Duration.between(d03, pastWeekInstant);

    System.out.println("t1 dias = " + t1.toDays());

    System.out.println("t2 dias = " + t2.toDays());

    System.out.println("t3 dias = " + t3.toDays());

    System.out.println("t4 dias = " + t4.toDays());
    }
}