package cs.algorithm.practice.hierarchical.iterative;

public class Solution {
    public int hierarchical(int i) {

        int sum = 1;
        for (int j = 2; j < i + 1; j++) {
            sum = sum * j;
        }

        return sum;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(new Solution().hierarchical(3));
    }
}
