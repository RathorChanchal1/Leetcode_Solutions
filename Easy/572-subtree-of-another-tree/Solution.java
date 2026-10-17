
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null) {
            return false;
        } else if (subRoot == null) {
            return false;
        } else if (root.val == subRoot.val) {
            if (isSameTree(root, subRoot)) {
                return true;
            }
            return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
        } else {
            return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
        }
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }

        return root.val == subRoot.val
            && isSameTree(root.left, subRoot.left)
            && isSameTree(root.right, subRoot.right);
    }
}
