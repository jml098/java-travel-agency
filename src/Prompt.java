import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Locale;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Prompt {

    /* Fields */
    private final Scanner scanner;
    private String errorMessage;

    /* Interfaces */
    private interface InputParser<T> {
        T parse(String input) throws NumberFormatException;
    }

    /* Constructors */
    Prompt(Scanner scanner) {
        this.scanner = scanner;
        this.scanner.useLocale(Locale.US);

        this.errorMessage = "Invalid value, ";
    }

    Prompt(Scanner scanner, String errorMessage) {
        this.scanner = scanner;
        this.scanner.useLocale(Locale.US);

        this.errorMessage = errorMessage;
    }

    /* Getters */
    public String getErrorMessage() {
        return errorMessage;
    }

    /* Setters */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /* Methods */
    public String ask(String prompt) {
        return askWithValidation(prompt, String::valueOf);
    }

    public int askInt(String prompt) {
        return askWithValidation(prompt, Integer::parseInt);
    }

    public double askDouble(String prompt) {
        return askWithValidation(prompt, Double::parseDouble);
    }

    public float askFloat(String prompt) {
        return askWithValidation(prompt, Float::parseFloat);
    }

    public boolean askBool(String prompt) {
        return askWithValidation(prompt, Boolean::parseBoolean);
    }

    public BigDecimal askBigDecimal(String prompt) {
        return askWithValidation(prompt, BigDecimal::new);
    }

    public BigInteger askBigInteger(String prompt) {
        return askWithValidation(prompt, BigInteger::new);
    }

    public long askLong(String prompt) {
        return askWithValidation(prompt, Long::parseLong);
    }

    public byte askByte(String prompt) {
        return askWithValidation(prompt, Byte::parseByte);
    }

    public short askShort(String prompt) {
        return askWithValidation(prompt, Short::parseShort);
    }

    private <T> T askWithValidation(String prompt, InputParser<T> parser) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                return parser.parse(input);
            } catch (NumberFormatException e) {
                System.out.print(errorMessage);
            }

            scanner.nextLine();
        }
    }
}
