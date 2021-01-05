package cs.algorithm.easy.palindrome.number;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        allTestCases().forEach(test -> System.out.println(solution.isPalindrome(test)));
    }

    private static List<Integer> allTestCases() {
        return List.of(121, -121, 10, -101);
    }
}
