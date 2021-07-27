
package Trees;

import java.util.*;

class Basics {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // leetcode all node k distance away

    ArrayList<Integer> distance_K(TreeNode root, TreeNode tar, int k) {
        if (root == null)
            return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<TreeNode> ans = new ArrayList<>();
        nodeToRootPath(root, tar.val, ans);
        TreeNode block = null;
        for (int i = 0; i < ans.size(); i++) {
            kDown(ans.get(i), k - i, block, res);
            block = ans.get(i);

        }
        return res;
    }

    boolean nodeToRootPath(TreeNode root, int data, ArrayList<TreeNode> res) {
        if (root == null)
            return false;

        if (root.val == data) {
            res.add(root);
            return true;

        }
        boolean ret = nodeToRootPath(root.left, data, res) || nodeToRootPath(root.right, data, res);
        if (ret) {
            res.add(root);
        }
        return ret;
    }

    void kDown(TreeNode root, int k, TreeNode block, ArrayList<Integer> res) {

        if (root == null || k < 0 || root == block)
            return;

        if (k == 0) {
            res.add(root.val);
            return;
        }
        kDown(root.left, k - 1, block, res);

        kDown(root.right, k - 1, block, res);
    }


    

    public static void main(String[] args) {
        Collections.sort(new ArrayList<>());
    }
}