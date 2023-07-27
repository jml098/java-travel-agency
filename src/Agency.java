import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Agency {
    public static void main(String[] args) {
        Prompt prompt = new Prompt(new Scanner(System.in));

        System.out.println("Welcome to Generation Holidays");
        while (prompt.ask("Do you want to book a vacation? (Y/N)").equalsIgnoreCase("Y")) {
            Vacation vacation = new Vacation();

            while (vacation.getDestination() == null) {
                try {
                    String destination = prompt.ask("Choose a destination: ");
                    vacation.setDestination(destination);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }

            while (vacation.getStart() == null) {
                try {
                    LocalDate start = LocalDate.parse(prompt.ask("Insert start date (YYYY-MM-DD): "));
                    vacation.setStart(start);
                } catch (DateTimeParseException dateTimeParseException) {
                    System.out.println("Invalid date format!");
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }

            }

            while (vacation.getEnd() == null) {
                try {
                    LocalDate end = LocalDate.parse(prompt.ask("Insert end date (YYYY-MM-DD): "));
                    vacation.setEnd(end);
                } catch (DateTimeParseException dateTimeParseException) {
                    System.out.println("Invalid date format!");
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }

            }

            System.out.println(
                    "Vacation to " + vacation.getDestination() +
                            " of " + vacation.getPeriod().getDays() + " days " +
                            "from " + vacation.getStart() +
                            " to " + vacation.getEnd() +
                            " has been booked!"
            );
        }
    }
}
