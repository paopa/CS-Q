package cs.algorithm.medium.add.two.numbers;

public class Test {
    public static void main(String[] args) {
        ListNode[] nodes = input1();
//        ListNode[] nodes = input2();
//        ListNode[] nodes = input3();
        ListNode node = Solution.addTwoNumbers(nodes[0], nodes[1]);
        System.out.println("end");
    }

    private static ListNode[] input1() {
        return new ListNode[]{
                new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4)))
        };
    }

    private static ListNode[] input2() {
        return new ListNode[]{
                new ListNode(9),
                new ListNode(1, new ListNode(9, new ListNode(9,
                        new ListNode(9, new ListNode(9, new ListNode(9,
                                new ListNode(9, new ListNode(9, new ListNode(9,
                                        new ListNode(9))))))))))
        };
    }

    private static ListNode[] input3() {
        return new ListNode[]{
                new ListNode(1, new ListNode(0, new ListNode(0,
                        new ListNode(0, new ListNode(0, new ListNode(0,
                                new ListNode(0, new ListNode(0, new ListNode(0,
                                        new ListNode(0, new ListNode(0, new ListNode(0,
                                                new ListNode(0, new ListNode(0, new ListNode(0,
                                                        new ListNode(0, new ListNode(0, new ListNode(0,
                                                                new ListNode(0, new ListNode(0, new ListNode(0,
                                                                        new ListNode(0, new ListNode(0, new ListNode(0,
                                                                                new ListNode(0, new ListNode(0, new ListNode(0,
                                                                                        new ListNode(0, new ListNode(0, new ListNode(0,
                                                                                                new ListNode(1))))))))))))))))))))))))))))))),
                new ListNode(5, new ListNode(6, new ListNode(4)))
        };
    }
}
