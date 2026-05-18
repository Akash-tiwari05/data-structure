package dynamicPrograming.dpontree;

public class MaxPathSum2SpecialNodes {

    public static void main(String[] args) {

        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;

        System.out.println(maxPathSum(root));
    }

    static int maxSum = 0;
    static int maxPathSum(Node root) {
        // code here
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }

    public static int solve(Node root){
        if(root == null) return 0;

        // leaf node
        if (root.left == null && root.right == null) {
            return root.data;
        }

        int left = solve(root.left);
        int right = solve(root.right);
        // if both children exist → valid leaf-to-leaf path
        if (root.left != null && root.right != null) {
            maxSum = Math.max(maxSum, left + right + root.data);

            // return best root-to-leaf path
            return root.data + Math.max(left, right);
        }

        // if only one child exists
        return (root.left == null)
                ? root.data + right
                : root.data + left;
    }
}

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}