package cs.algorithm.hard.nqueens;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space, respectively.
 * <p>
 * Example 1:
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 * <p>
 * Example 2:
 * Input: n = 1
 * Output: [["Q"]]
 * <p>
 * <p>
 * Constraints:
 * 1 <= n <= 9
 * <p>
 * link: https://leetcode.com/problems/n-queens/
 */
public class Solution {

    private static final char QUEEN = 'Q';
    private static final char DOT = '.';

    public List<List<String>> solveNQueens(int n) {
        if (n > 1 && n <= 3) {
            return List.of();
        }
        List list = new ArrayList();
        // todo

        return list;
    }


}

