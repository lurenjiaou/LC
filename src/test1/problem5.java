package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class problem5 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    HashMap<Integer,TreeNode> mp;
    public TreeNode xorTree (TreeNode root, ArrayList<ArrayList<Integer>> op) {
        // write code here
        mp = new HashMap<>();
        dfs(root);
        for (int i = 0; i < op.size(); i++) {
            ArrayList<Integer> tmp = op.get(i);
            int index = tmp.get(0);
            int num = tmp.get(1);
            TreeNode cur = mp.get(index);
            TreeNode P = dfs2(cur,num);
            System.out.println(P.val);
        }
        return root;
    }

    private TreeNode dfs2(TreeNode cur, int num) {
        if (cur==null)return null;
        cur.val = cur.val^num;

        cur.left=dfs2(cur.left,num);
        cur.right=dfs2(cur.right,num);
        return cur;
    }

    private void dfs(TreeNode root) {
        if (root==null)return;
        mp.put(root.val, root);
        root.val = 0;
        dfs(root.left);
        dfs(root.right);
    }
}
