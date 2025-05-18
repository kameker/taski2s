package Task5;

public class BinaryTree<T> {
    class SimpleTreeNode {
        public T value;
        public SimpleTreeNode left;
        public SimpleTreeNode right;
        public SimpleTreeNode (T value, SimpleTreeNode left, SimpleTreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
        public SimpleTreeNode(T value) {
            this(value, null, null);
        }
    }
    public static void main(String[] args) {

    }
}
