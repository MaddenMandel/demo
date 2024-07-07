package algorithm.day3;


public class LeetCode108 {

    private TreeNode sortArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length -1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        LeetCode108 leetcode = new LeetCode108();
        TreeNode treeNode = leetcode.sortArrayToBST(nums);
        treeNode.printTree(treeNode);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }

        private TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        private void printTree(TreeNode treeNode){
            if(treeNode == null){
                return;
            }
            printTree(treeNode.left);
            System.out.println(treeNode.val);
            printTree(treeNode.right);
        }

    }
}
