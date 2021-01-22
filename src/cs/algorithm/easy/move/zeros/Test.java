package cs.algorithm.easy.move.zeros;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = {9, 0, 4, 6, 0, 7, 0, 1, 0};
//		int[] a = {0,3,0,8,1,0,0,2,0};
//		int[] a = {0,1,0,3,12};
        Solution.moveZeroes(a);
        Arrays.stream(a).forEach(v -> System.out.print(v + " "));
    }
}
