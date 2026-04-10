package recursion;

public class HeightOfBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);


        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {

        if(root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(rightDepth,leftDepth)+1;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}