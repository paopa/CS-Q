package cs.algorithm.practice.hierarchical.recursion;

/**
 * 階層函數演算法
 *
 * tail recursion:
 * 在 code 中最後一個指令是遞迴呼叫
 * 在每次呼叫後，再回到前一次呼叫的 return ，不會再進行其他計算工作。
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

class Test {
    public static void main(String[] args) {
        System.out.println(Solution.hierarchical(4));
    }
}