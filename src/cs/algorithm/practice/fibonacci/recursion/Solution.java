package cs.algorithm.practice.fibonacci.recursion;

/**
 * 費伯納序列 (Fibonacci Polynomial)
 */
public class Solution {

    public static int fibonacci(int input) {
        if (input == 0) {
            return 0;
        } else if (input == 1) {
            return 1;
        }
        return fibonacci(input - 1) + fibonacci(input - 2);
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(Solution.fibonacci(9));
    }
}