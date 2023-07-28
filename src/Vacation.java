import java.time.LocalDate;
import java.time.Period;

public class Vacation {
    String destination;
    LocalDate start;
    LocalDate end;

    public Vacation(String destination, LocalDate start, LocalDate end) throws RuntimeException {
        this.destination = validateDestination(destination);
        this.start = validateStart(start);
        this.end = validateEnd(end);
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

    public void setDestination(String destination) {
        this.destination = validateDestination(destination);
    }

    public void setStart(LocalDate start) {
        this.start = validateStart(start);
    }

    public void setEnd(LocalDate end) {
        this.end = validateEnd(end);
    }

    private String validateDestination(String destination) {
        if (!(destination == null || destination.isBlank())) return destination;
        else throw new RuntimeException("Destination cannot be empty!");
    }

    private LocalDate validateStart(LocalDate start) {
        if (!(start == null || start.isBefore(LocalDate.now()))) return start;
        else throw new RuntimeException("Start date cannot be in the past or null.");
    }

    private LocalDate validateEnd(LocalDate end) {
        if (!(end == null || end.isBefore(this.start))) return end;
        else throw new RuntimeException("End date cannot be before start date or null.");
    }
}
