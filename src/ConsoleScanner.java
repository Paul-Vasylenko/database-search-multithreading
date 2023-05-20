import java.util.Scanner;

public class ConsoleScanner {
    public String requestValue(String prompt, String defaultValue) {
        System.out.print(prompt);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            input = defaultValue;
        }

        return input;
    }

    public int requestValue(String prompt, int defaultValue) {
        System.out.print(prompt);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            input = Integer.toString(defaultValue);
        }

        return Integer.parseInt(input);
    }
}
