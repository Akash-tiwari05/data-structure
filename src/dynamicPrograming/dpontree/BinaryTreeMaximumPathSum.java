package dynamicPrograming.dpontree;

public class BinaryTreeMaximumPathSum {

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

        System.out.println(maxPathSum(head));
    }

    static int maxSum = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }

    public static int solve(TreeNode root){
        if(root == null) return 0;


        int left = Math.max(0,solve(root.left));
        int right = Math.max(0,solve(root.right));

        int currentNode = root.val+left+right;

        maxSum = Math.max(maxSum, currentNode);

        return root.val + Math.max(left, right);
    }

}
