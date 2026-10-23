
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1,
                         0, inorder.length - 1);
    }

    TreeNode buildTree(int[] preorder, int[] inorder,
                       int pres, int prel, int ins, int inl) {

        if (pres > prel || ins > inl) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pres]);

        int mid = ins;
        while (mid <= inl && inorder[mid] != preorder[pres]) {
            mid++;
        }

        int leftSize = mid - ins;

        root.left = buildTree(
            preorder, inorder,
            pres + 1, pres + leftSize,
            ins, mid - 1
        );

        root.right = buildTree(
            preorder, inorder,
            pres + leftSize + 1, prel,
            mid + 1, inl
        );

        return root;
    }
}
