package Assignment_Lession_11;

public class MyBinarySearchTree {

    private BinaryNode root;

    public MyBinarySearchTree() {
        root = null;
    }

    public void printTree() {
        if (root == null) {
            System.out.println("Empty tree");
        } else {
            printTree(root);
        }
    }

    private void printTree(BinaryNode t) {
        if (t != null) {
            printTree(t.left);
            System.out.print(t.element + ", ");
            printTree(t.right);
        }
    }

    // implement
    public void preOrder() {
        System.out.println("\nPreOrder print");
        preOrder(root);
    }

    private void preOrder(BinaryNode t) {
        if (t != null) {
            System.out.print(t.element + ", ");
            preOrder(t.left);
            preOrder(t.right);
        }
    }

    public void postOrder() {
        System.out.println("\nPostOrder print");
        postOrder(root);
    }

    private void postOrder(BinaryNode t) {
        if (t != null) {
            preOrder(t.left);
            preOrder(t.right);
            System.out.print(t.element + ", ");
        }
    }

    public boolean contains(Integer key) {
        return contains(key, root);
    }

    private boolean contains(Integer key, BinaryNode t) {
        if (t == null) {
            return false;
        }

        int compare = key.compareTo(t.element);
        if (compare < 0) {
            return contains(key, t.left);
        } else if (compare > 0) {
            return contains(key, t.right);
        } else {
            return true;
        }
    }

    public Integer getRoot() {
        return root.element;
    }

    public Integer leafNodes() {
        return leafNodes(root);
    }

    private int leafNodes(BinaryNode t) {
        int res = t.element;
        if (t.left != null) {
            res = leafNodes(t.left);
        }
        if(t.right != null) {
            res = leafNodes(t.right);
        }
        return res;
    }

    public void listLeafNodes() {
        listLeafNodes(root);
    }

    private void listLeafNodes(BinaryNode t) {
        if(t != null) {
            if(t.left == null && t.right == null) {
                System.out.print(t.element + ", ");
            }
            listLeafNodes(t.left);
            listLeafNodes(t.right);
        }
    }


    public int size() {
        return size(root);
    }

    private int size(BinaryNode t) {
        if (t == null) {
            return 0;
        } else {
            return 1 + size(t.left) + size(t.right);
        }
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public Integer findMin() {
        return findMin(root);
    }

    private Integer findMin(BinaryNode t) {
        if (t.left == null) {
            return t.element;
        }
        return findMin(t.left);
    }

    public Integer findMax() {
        return findMax(root);
    }

    private Integer findMax(BinaryNode t) {
        if(t.right == null) {
            return t.element;
        }
        return findMax(t.right);
    }

    public void insert(Integer x) {
        if (root == null) {
            root = new BinaryNode(x);
            return;
        } else {
            BinaryNode n = root;
            boolean inserted = false;

            while (!inserted) {
                if (x.compareTo(n.element) < 0) {
                    if (n.left == null) {
                        n.left = new BinaryNode(x);
                        inserted = true;
                    } else {
                        n = n.left;
                    }
                } else if (x.compareTo(n.element) > 0) {
                    if (n.right == null) {
                        n.right = new BinaryNode(x);
                        inserted = true;
                    } else {
                        n = n.right;
                    }
                } else {
                    inserted = true;
                }
            }
        }
    }

    private class BinaryNode {
        private Integer element;
        private BinaryNode left;
        private BinaryNode right;

        public BinaryNode(Integer element, BinaryNode left, BinaryNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        BinaryNode(Integer theElement) {
            this(theElement, null, null);
        }
    }

    public static void main(String[] args) {
        MyBinarySearchTree mybst = new MyBinarySearchTree();

        int[] a = {15, 12, 9, 56, 1, 16, 19, 22, 3, 100, 2, 25};

        for (int i = 0; i < a.length; i++) {
            mybst.insert(a[i]);
        }

        mybst.printTree();
        mybst.preOrder();
        mybst.postOrder();
        System.out.println();
        System.out.println(mybst.contains(3));
        System.out.println(mybst.contains(20));
        System.out.println("Root: " + mybst.getRoot());
        System.out.print("Leaf Node: " + mybst.leafNodes() + "\n");
        System.out.println("Size: " + mybst.size());
        System.out.println("Is empty: " + mybst.isEmpty());
        System.out.println("Min: " + mybst.findMin());
        System.out.println("Max: " + mybst.findMax());

        mybst.listLeafNodes();
    }
}
