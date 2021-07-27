package Trees;

import java.util.ArrayList;
import java.util.HashSet;

import jdk.internal.jshell.tool.resources.l10n;

public class Basics_2 {

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

    // Burning tree Node

    ArrayList<ArrayList<Integer>> BurningTreeNodes(TreeNode root, TreeNode target) {

        if (root == null)
            return new ArrayList<>();
        ArrayList<TreeNode> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        nodeToRoot(root, ans, target);
        TreeNode blocked = null;
        for (int i = 0; i < ans.size(); i++) {

            kdown(ans.get(i), blocked, i, res);
            blocked = ans.get(i);
        }

        return res;

    }

    void kdown(TreeNode root, TreeNode blk, int time, ArrayList<ArrayList<Integer>> res) {
        if (root == null || root == blk)
            return;

        if (time == res.size())
            res.add(new ArrayList<>());
        res.get(time).add(root.val);
        kdown(root.left, blk, time + 1, res);
        kdown(root.right, blk, time + 1, res);
    }

    int BurningTreeNodes_2(TreeNode root, TreeNode target, ArrayList<ArrayList<Integer>> res) {
        if (root == null)
            return -1;// did n't get the data
        if (root.val == target.val) {
            kdown(root, null, 0, res);
            return 1;
        }
        int lres = BurningTreeNodes_2(root.left, target, res);// 1
        if (lres != -1) {
            kdown(root, root.left, lres, res);
            return lres + 1;
        }
        int rres = BurningTreeNodes_2(root.right, target, res);
        if (rres != -1) {
            kdown(root, root.right, rres, res);
            return rres + 1;
        }
        return -1;
    }

    // burning tree node with water at some nodes

    ArrayList<ArrayList<Integer>> burningTree_withWater(TreeNode root, TreeNode target, HashSet<Integer> water) {
        if (root == null)
            return new ArrayList<>();
        ArrayList<TreeNode> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        nodeToRoot(root, ans, target);
        TreeNode blocked = null;
        for (int i = 0; i < ans.size(); i++) {

            if (!kdown_3(ans.get(i), blocked, water, i, res)) {
                return res;
            }
            blocked = ans.get(i);
        }

        return res;
    }

    boolean kdown_3(TreeNode root, TreeNode blk, HashSet<Integer> map, int time, ArrayList<ArrayList<Integer>> res) {
        boolean flag = false;
        if (root == null || root == blk || map.contains(root.val))
            return false;

        if (res.size() == time)
            res.add(new ArrayList<>());
        res.get(time).add(root.val);
        flag = true;
        boolean lres = kdown_3(root.left, blk, map, time + 1, res);
        boolean rres = kdown_3(root.right, blk, map, time + 1, res);
        return lres || rres || flag;
    }

    int burningTree_withWater_2(TreeNode root, TreeNode tar, HashSet<Integer> map, ArrayList<ArrayList<Integer>> res) {

        if (root == null)
            return -1;
        if (map.contains(root.val))
            return 0;
        if (root.val == tar.val) {
            kdown_4(root, null, 0, map, res);
            return 1;
        }

        int lres = burningTree_withWater_2(root.left, tar, map, res);
        if (lres > 0) {
            if (map.contains(root.val))
                return 0;
            kdown_4(root, root.left, lres, map, res);
            return lres + 1;
        }
        if (lres == 0)
            return 0;
        int rres = burningTree_withWater_2(root.right, tar, map, res);
        if (rres > 0) {
            if (map.contains(root.val))
                return 0;
            kdown_4(root, root.right, rres, map, res);
            return rres + 1;
        }
        if (rres == 0)
            return 0;
        return -1;
    }

    void kdown_4(TreeNode root, TreeNode blk, int time, HashSet<Integer> map, ArrayList<ArrayList<Integer>> res) {
        if (root == null || root == blk || map.contains(root.val))
            return;

        if (res.size() == time)
            res.add(new ArrayList<>());
        res.get(time).add(root.val);
        kdown_4(root.left, blk, time, map, res);
        kdown_4(root.right, blk, time, map, res);

    }

    // BinarySearch TRee

    int size(TreeNode root) {
        return root != null ? size(root.left) + size(root.right) + 1 : 0;
    }

    int height(TreeNode root) {
        return root != null ? Math.max(height(root.left), height(root.right)) + 1 : -1;
    }

    int max(TreeNode root) {
        if (root == null)
            return -(int) 1e9;
        TreeNode crt = root;
        while (crt.right != null) {
            crt = crt.right;
        }
        return crt.val;
    }

    int min(TreeNode root) {
        if (root == null)
            return (int) 1e9;
        TreeNode crt = root;
        while (crt.left != null) {
            crt = crt.left;
        }
        return crt.val;
    }

    boolean find(TreeNode root, int target) {
        if (root == null)
            return false;

        if (root.val > target)
            return find(root.left, target);
        if (root.val < target)
            return find(root.right, target);
        else {
            return true;
        }
    }

    boolean find_2(TreeNode root, int target) {
        if (root == null)
            return false;

        TreeNode crt = root;
        while (crt != null) {
            if (crt.val == target)
                return true;
            if (crt.val > target)
                crt = crt.right;
            else {
                crt = crt.left;
            }
        }
        return false;

    }


    ArrayList<Integer> nodeToRootPath(TreeNode root, int tar){
        if(root==null) return new ArrayList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        
    }
}
