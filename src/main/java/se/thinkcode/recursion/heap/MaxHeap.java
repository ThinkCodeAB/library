package se.thinkcode.recursion.heap;

public class MaxHeap {
    private Node root = null;

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value > root.value) {
            int oldValue = root.value;
            root.value = value;
            value = oldValue;
        }

        if (root.left == null) {
            root.left = new Node(value);
        } else if (root.right == null) {
            root.right = new Node(value);
        } else {
            root.left = insert(root.left, value);
        }

        return root;
    }

    public int getMax() {
        if (root == null) {
            System.out.println("Heap is empty!");
            return -1;
        }

        int max = root.value;

        if (root.left == null && root.right == null) {
            root = null;
            return max;
        }

        Node last = findLast(root);
        delete(root, last);

        last.left = root.left;
        last.right = root.right;
        root = last;
        root = reHeapify(root);

        return max;
    }

    private void delete(Node node, Node unwanted) {
        if (node == null) {
            return;
        }

        if (node.left == unwanted) {
            node.left = null;
            return;
        } else {
            delete(node.left, unwanted);
        }

        if (node.right == unwanted) {
            node.right = null;
        } else {
            delete(node.right, unwanted);
        }
    }

    private Node findLast(Node root) {
        if (root.left == null && root.right == null) {
            return root;
        }

        if (root.left != null) {
            return findLast(root.left);
        }

        return findLast(root.right);
    }

    public Node getRoot() {
        return root;
    }

    private Node reHeapify(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left != null && root.left.value > root.value) {
            int temp = root.value;
            root.value = root.left.value;
            root.left.value = temp;
        }

        if (root.right != null && root.right.value > root.value) {
            int temp = root.value;
            root.value = root.right.value;
            root.right.value = temp;
        }

        root.left = reHeapify(root.left);
        root.right = reHeapify(root.right);

        return root;
    }
}
