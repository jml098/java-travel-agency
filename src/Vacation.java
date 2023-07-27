import java.time.LocalDate;
import java.time.Period;

public class Vacation {
    String destination;
    LocalDate start;
    LocalDate end;

    public Vacation() {
    }

    public Vacation(String destination, LocalDate start, LocalDate end) throws RuntimeException {
        setDestination(destination);
        setStart(start);
        setEnd(end);
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public Period getPeriod() {
        return Period.between(this.start, this.end);
    }

    public void setDestination(String destination) throws RuntimeException {
        if (this.validateDestination(destination)) this.destination = destination;
        else throw new RuntimeException("Destination cannot be empty!");
    }

    public void setStart(LocalDate start) {
        if (this.validateStart(start)) this.start = start;
        else throw new RuntimeException("Start date cannot be in the past or null.");
    }

    public void setEnd(LocalDate end) {
        if (this.validateEnd(end)) this.end = end;
        else throw new RuntimeException("End date cannot be before start date or null.");
    }

    private boolean validateDestination(String destination) {
        return !(destination == null || destination.isBlank());
    }

    private boolean validateStart(LocalDate start) {
        return !(destination == null || start.isBefore(LocalDate.now()));
    }

    private boolean validateEnd(LocalDate end) {
        return !(destination == null || end.isBefore(this.start));
    }
}
