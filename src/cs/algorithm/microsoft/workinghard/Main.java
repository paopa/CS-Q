package cs.algorithm.microsoft.workinghard;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            new Application().start();
        }
    }
}

class Application {
    int n = 0;
    int min = 0;
    int max = 0;
    int count = 0;
    int mark = 0;
    int choose = 1;
    int[] seg;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        min = scanner.nextInt();
        max = scanner.nextInt();
        count = 0;
        seg = new int[n];
        for (int i = 0; i < seg.length; i++) {
            seg[i] = scanner.nextInt();
        }
        file();
        System.out.println(count / 2);
    }

    void file() {
        for (int i = mark; i < n; i++) {
            for (int j = choose; j - 1 < n - mark; j++) {
                check(add(mark, j, 0) / j);
            }
        }
    }

    void check(int number) {
        if (min <= number && number <= max) {
            count++;
        }
    }

    int add(int mark, int choose, int sum) {
        for (int j = mark; j < choose; j++) {
            sum += seg[j];
        }
        return sum;
    }
}
