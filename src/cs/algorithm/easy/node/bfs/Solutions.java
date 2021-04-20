package cs.algorithm.easy.node.bfs;

import java.util.*;

import static java.util.Objects.isNull;

public abstract class Solutions {

    public abstract String traversal(Node node);

    public static Solutions factory(String solution) {
        switch (solution) {
            case "1":
                return new Solution1();
            default:
                throw new IllegalArgumentException();
        }
    }

    private static class Solution1 extends Solutions {

        private final Queue<Node> queue = new LinkedList<>();
        private final List<String> list = new ArrayList<>();

        @Override
        public String traversal(Node node) {
            queue.add(node);
            Node head;
            while (!queue.isEmpty()) {
                head = queue.remove();
                list.add(String.valueOf(head.value));
                if (!isNull(head.left)) {
                    queue.add(head.left);
                }
                if (!isNull(head.right)) {
                    queue.add(head.right);
                }
            }
            return String.join(",", list);
        }
    }
}

class Node {
    Node left;
    Node right;
    int value;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(int value) {
        this(value, null, null);
    }
}

class Test {
    public static void main(String[] args) {
        List.of(
                new TestCase(TestCase.case1()),
                new TestCase(TestCase.case2())
        ).forEach(test -> System.out.println(Solutions.factory("1").traversal(test.root)));
    }

    private static class TestCase {
        Node root;

        public TestCase(Node node) {
            this.root = node;
        }

        public static Node case1() {
            return new Node(1,
                    new Node(2,
                            new Node(4),
                            new Node(5)
                    ),
                    new Node(3,
                            null,
                            new Node(6)
                    )
            );
        }

        public static Node case2() {
            return new Node(1,
                    new Node(2,
                            new Node(4,
                                    new Node(6),
                                    null
                            ),
                            new Node(5,
                                    null,
                                    new Node(7)
                            )
                    ),
                    new Node(3)
            );
        }
    }
}
