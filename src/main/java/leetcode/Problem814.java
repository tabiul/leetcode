package leetcode;

public class Problem814 {

    public TreeNode pruneTree(TreeNode root) {
        if( root == null) return null;
        if (root.left != null) {
            root.left = pruneTree(root.left);
        }
        if(root.right != null) {
            root.right = pruneTree(root.right);
        }
        if(root.val == 1) return root;
        if(root.val == 0 && (root.left != null || root.right != null)) return root;
        return null;
    }

    public static void main(String[] args) {
        Problem814 problem814 = new Problem814();
        // 1 0 0 1
        TreeNode testCase = new TreeNode(1);

        testCase.left = new TreeNode(1);
        testCase.right = new TreeNode(0);

        testCase.left.left = new TreeNode(1);
        testCase.left.right = new TreeNode(1);

        testCase.right.left = new TreeNode(0);
        testCase.right.right = new TreeNode(1);

        testCase.left.left.left = new TreeNode(0);

        testCase = problem814.pruneTree(testCase);
        System.out.println(testCase);
    }
}
