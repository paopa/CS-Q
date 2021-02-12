package cs.algorithm.practice.pascal.iterative;

public class Solution {

    public void pascal(int i) {
        for (int row = 0; row < i; row++) {
            for (int n = 0; n <= row; n++) {
                System.out.print(binomialCoefficient(row, n) + " ");
            }
            System.out.println();
        }
    }

    private int binomialCoefficient(int row, int n) {
        int result = 1;
        if (n == 0) {
            return result;
        }
        for (int i = 1; i <= n; i++) {
            result = result * (row - i + 1) / i;
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        new Solution().pascal(4);
    }
}
