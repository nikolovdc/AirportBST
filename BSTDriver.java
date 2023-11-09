public class BSTDriver {
    public static Node root; // The root node of the tree.

    public BSTDriver() {
        root = null;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = new Node(17, 17);
        tree.root.setLeft(new Node(10, 10));
        tree.root.setRight(new Node(20, 20));
        tree.root.getLeft().setLeft(new Node(4, 4));
        tree.root.getLeft().getLeft().setRight(new Node(7, 7));
        tree.root.getLeft().setRight(new Node(15, 15));
        tree.root.getLeft().getRight().setLeft(new Node(14, 14));
        tree.root.getRight().setRight(new Node(22, 22));
        tree.root.getRight().setLeft(new Node(18, 18));
        tree.root.getRight().getRight().setRight(new Node(24, 24));
        tree.root.getRight().getRight().getRight().setLeft(new Node(23, 23));
        tree.insert(16, 16);
        // Insert Test
        System.out.println(
                "\nInorder Traversal of my Binary Tree is: ");
        tree.print();
        // Pred Test
        int t = 16;
        Node output = tree.pred(t);
        if (output != null)
            System.out.println("Pred search test. Pred of " + t + " is = " + output.getTime());
        else
            System.out.println("Null Pred for " + t);
        // Succ Test
        int e = 16;
        Node output2 = tree.succ(t);
        if (output != null)
            System.out.println("Succ search test. Succ of " + e + " is = " + output2.getTime());
        else
            System.out.println("Null Succ for " + e);
        // Delete Test
  
        tree.delete(15);
            System.out.println(
            "\nInorder Traversal of my Binary Tree is: ");
        tree.print();       
    }

}


