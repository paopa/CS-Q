package cs.algorithm.hard.nqueens;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        int input = 0;
        List<List<String>> ans = new Solution().solveNQueens(input);
        System.out.println(ans);
    }
}
