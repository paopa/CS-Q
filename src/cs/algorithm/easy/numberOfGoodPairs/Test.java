package cs.algorithm.easy.numberOfGoodPairs;

import cs.algorithm.base.util.Runtime;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws Exception {
        Runtime.start();
        System.out.println(Solution.switchMethod(generateNums(0), "v2"));
        Runtime.end();
    }

    private static int[] generateNums(int mode) {
        switch (mode) {
            case 1:
                return new int[]{1, 2, 3, 1, 1, 3};
            case 2:
                return new int[]{1, 1, 1, 1};
            case 3:
                return new int[]{1, 2, 3};
            default:
                return randomNums();
        }
    }

    private static int[] randomNums() {
        int x = (int) (Math.random() * 100 + 1);
        int[] a = new int[x];
        int index = 0;
        while (x > 0) {
            a[index] = (int) (Math.random() * 100 + 1);
            index++;
            x--;
        }
        System.out.println(Arrays.toString(a));
        return a;
    }
}
