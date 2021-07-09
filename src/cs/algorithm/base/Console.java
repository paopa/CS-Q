package cs.algorithm.base;

import java.util.Scanner;

public interface Console<O> {

    default O execute(String input) {
        throw new UnsupportedOperationException();
    }

    static void execute(Console console) {
        final Scanner scanner = new Scanner(System.in);
        String line;
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            System.out.println(console.execute(line));
        }
    }
}
