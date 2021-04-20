package cs.algorithm.easy.node.reverse;

import java.util.List;

import static java.util.Objects.isNull;

/**
 * singly-linked node reverse
 */
public abstract class Solutions {

    public abstract Node reverse(Node node);

    public static Solutions factory(String solution) {
        if (isNull(solution)) {
            throw new IllegalArgumentException();
        }
        switch (solution) {
            case "1":
                return new Solution1();
            case "2":
                return new Solution2();
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * iterative
     * time complexity: O(n)
     * space complexity: O(1)
     */
    private static class Solution1 extends Solutions {

        @Override
        public Node reverse(Node node) {
            Node prev = null;
            Node curr = node;
            Node next;
            while (!isNull(curr)) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }

    /**
     * recursive
     * time complexity: O(n)
     * space complexity: O(n)
     */
    private static class Solution2 extends Solutions {

        @Override
        public Node reverse(Node head) {
            if (isNull(head) || isNull(head.next)) {
                return head;
            }
            Node node = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return node;
        }
    }
}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class Test {
    public static void main(String[] args) {
        List.of(
                new TestCase(TestCase.case1()),
                new TestCase(TestCase.case2())
        ).forEach(test -> System.out.println(Solutions.factory("2").reverse(test.root)));
    }

    private static class TestCase {
        Node root;

        public TestCase(Node root) {
            this.root = root;
        }

        public static Node case1() {
            return new Node(1, new Node(2, new Node(3, new Node(4))));
        }

        public static Node case2() {
            return new Node(1);
        }
    }
}
