package cs.algorithm.microsoft.ding.legacy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        while (true) {
            new Application().start();
        }
    }
}

class Application {

    private int n;
    private int m;
    private int[] listA;
    private int[] listB;
    private final List<Integer> segs = new ArrayList<>();
    private int total = 0;
    private int count = 0;

    public void start() {
        prepare(new Scanner(System.in));
        System.out.println(split());
    }

    private int split() {
        AtomicInteger seg = new AtomicInteger();
        segs.forEach(seg::addAndGet);
        if (seg.get() != total) return 0;
        if (n >= 3) {
            split(listA, n);
        }
        if (m >= 3) {
            split(listB, m);
        }
        return count;
    }

    /**
     * 1 2 3 4 5
     * 0 1 2 3 4
     * 3 3 3 3 3
     */

    private void split(int[] in, int n) {
        List<Integer> tmp = new ArrayList<>(segs);
        for (int i = 0; i < n - 2; i++) {
            int x = sum(in, i, 0);
            if (tmp.contains(x)) {
                for (int j = i + 1; j < n - 1; j++) {
                    int y = sum(in, j, i + 1);
                    if (tmp.contains(y)) {
                        int z = sum(in, n - 1, j + 1);
                        if (tmp.contains(z)) {
                            remove(tmp, x);
                            remove(tmp, y);
                            remove(tmp, z);
                            if (tmp.isEmpty()) {
                                count++;
                                tmp = new ArrayList<>(segs);
                            }
                        }
                    }
                }
            }
        }
    }

    private void remove(List<Integer> tmp, int x) {
        int t = tmp.lastIndexOf(x);
        if (t != -1) {
            tmp.remove(t);
        }
    }

    private int sum(int[] in, int i, int s) {
        int t = 0;
        for (int j = s; j <= i; j++) {
            t += in[j];
        }
        return t;
    }

    private void prepare(Scanner scanner) {
        n = scanner.nextInt();
        m = scanner.nextInt();
        if (1 > n || n > 50 || 1 > m || m > 50 || Math.max(n, m) < 3)
            throw new IllegalArgumentException();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
                total += matrix[i][j];
            }
        }
        AtomicInteger i = new AtomicInteger();
        AtomicInteger j = new AtomicInteger();

        listA = new int[n];
        listB = new int[m];
        for (int[] ints : matrix) {
            Arrays.stream(ints).forEach(x -> listA[i.get()] += x);
            i.getAndIncrement();

            j.set(0);
            Arrays.stream(ints).forEach(x -> {
                listB[j.get()] += x;
                j.getAndIncrement();
            });
        }

        for (int k = 0; k < 3; k++) {
            segs.add(scanner.nextInt());
        }
    }

}
