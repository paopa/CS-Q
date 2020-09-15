package cs.algorithm.practice.hierarchical;

/**
 * 階層函數演算法
 */
public class Solution {

    public static int hierarchical(int input) {
        if (input == 0) {
            return 0;
        }
        if (input == 1) {
            return 1;
        }
        return input * hierarchical(input - 1);
    }
}
