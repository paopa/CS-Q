package cs.algorithm.microsoft.slogan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            new Application().start();
        }
    }
}

/**
 * 0101101
 * 010101
 * 001101
 */
class Application {

    private static final char M = 'M';
    private static final char $ = '$';
    private StringBuilder sb = new StringBuilder();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        for (char c : input) {

        }

    }
}
