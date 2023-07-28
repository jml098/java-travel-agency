import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Agency {
    public static void main(String[] args) {
        Prompt prompt = new Prompt(new Scanner(System.in));

        System.out.println("Welcome to Generation Holidays");
        while (prompt.ask("Do you want to book a vacation? (Y/N) ").equalsIgnoreCase("Y")) {
            Vacation vacation = null;

            while (vacation == null) {
                String destination;
                LocalDate start = null;
                LocalDate end = null;

                destination = prompt.ask("Choose a destination: ");

                while (start == null) {
                    try {
                        start = LocalDate.parse(prompt.ask("Insert start date (YYYY-MM-DD): "));
                    } catch (DateTimeParseException dateTimeParseException) {
                        System.out.println("Invalid date format!");
                    }
                }

                while (end == null) {
                    try {
                        end = LocalDate.parse(prompt.ask("Insert end date (YYYY-MM-DD): "));
                    } catch (DateTimeParseException dateTimeParseException) {
                        System.out.println("Invalid date format!");
                    }
                }

                try {
                    vacation = new Vacation(destination, start, end);
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
