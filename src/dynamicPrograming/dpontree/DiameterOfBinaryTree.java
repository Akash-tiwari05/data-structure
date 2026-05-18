package dynamicPrograming.dpontree;

public class DiameterOfBinaryTree {


    public static void main(String[] args) {

        TreeNode head = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);

        head.left = a;
        head.right = b;
        a.left = c;
        a.right = d;

        System.out.println(diameterOfBinaryTree(head));
    }

    static int diameter = 0;
    public static int diameterOfBinaryTree(TreeNode root) {

        height(root);
        return diameter;
    }

    private static int height(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        // diameter through current node
        diameter = Math.max(diameter, left + right);

        // return height
        return 1 + Math.max(left, right);
    }

}
