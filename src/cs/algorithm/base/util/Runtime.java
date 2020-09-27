package cs.algorithm.base.util;

public class Runtime {

    private static long startTime;
    private static long endTime;

    public static void start() {
        startTime = System.currentTimeMillis();
    }

    public static void end() {
        endTime = System.currentTimeMillis();
        System.out.printf("runtime: %d ms \n", endTime - startTime);
    }
}
