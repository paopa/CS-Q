package cs.algorithm.practice.dynamic;

/**
 * 用動態規劃法 進行費伯納序列 (Fibonacci Polynomial)
 * 會將已算過的值存入 暫存內
 */
public class Solution {

    public static int[] output = new int[1000];

    public static int fibonacci(int n) {
        int result;
        result = output[n];
        if (result == 0) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            return output[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
        return result;
    }
}
