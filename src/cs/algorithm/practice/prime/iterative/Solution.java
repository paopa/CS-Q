package cs.algorithm.practice.prime.iterative;

public class Solution {
    /*利用 array 紀錄是 prime number 的數字為 false */
    public int[] findPrimeNumber(int max) {
        boolean[] filter = new boolean[max + 1];
        int count = 0;
        filter[0] = true;
        filter[1] = true;
        int num = 2;
        while (num <= max) {
            if (!filter[num]) {
                for (int i = num + num; i <= max; i += num) {
                    if (filter[i]) continue;
                    filter[i] = true;
                }
                count++;
            }
            num++;
        }

        int[] prime = new int[count];
        int j = 0;
        for (int i = 0; i < filter.length; i++) {
            if (!filter[i]) {
                prime[j] = i;
                j++;
            }
        }
        return prime;
    }
}

class Test {
    public static void main(String[] args) {
        final int max = 100_000;
        int[] ints = new Solution().findPrimeNumber(max);
        System.out.println("print all prime numbers:");
        for (int i = 0; i < ints.length; i++) {
            if ((i + 1) % 10 == 0)
                System.out.printf("%d\n", ints[i]);
            else
                System.out.printf("%d\t", ints[i]);

        }
        System.out.printf("\nhave %d prime numbers find 2 to %d\n", ints.length, max);
    }
}
