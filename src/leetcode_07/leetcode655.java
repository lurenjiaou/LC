package leetcode_07;

import java.util.ArrayList;
import java.util.List;



public class leetcode655 {
    int maxd = 0;
    int n = 1;
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
    public List<List<String>> printTree(TreeNode root) {
        dfs(root,1);
        for (int i = 0; i < maxd; i++) {
            n *=2;
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < maxd; i++) {
            List<String> tmp = new ArrayList<>();
            for (int j = 0; j < n-1; j++) {
                tmp.add("");
            }
            ans.add(tmp);
        }
        System.out.println(n);
        System.out.println(maxd);
        dfs2(root,0,(n-2)/2,ans);
        return ans;
    }

    private void dfs2(TreeNode root, int i, int j, List<List<String>> ans) {
        if (root==null)return;
        String tmp = Integer.toString(root.val);
        int index = 1;
        for (int k = 0; k < maxd-1-i; k++) {
            index *=2;
        }
        ans.get(i).set(j,tmp);
        dfs2(root.left,i+1,j-index,ans);
        dfs2(root.right,i+1,j+index,ans);

    }

    void dfs(TreeNode root, int d){
        if (root==null)return;
        maxd = Math.max(maxd,d);
        dfs(root.left,d+1);
        dfs(root.right,d+1);
    }
    public static void main(String[] args) {

    }
}
