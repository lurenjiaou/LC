package test1;

import java.util.*;

public class problem4 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    HashMap<TreeNode,Integer> mp;
    public ArrayList<TreeNode> deleteLevel (TreeNode root, ArrayList<Integer> a) {
        // write code here
        HashSet<Integer> set = new HashSet<>();
        for (int num:a) set.add(num);
        mp = new HashMap<>();
        dfs(root,1);
        Queue<TreeNode>q = new ArrayDeque<>();
        q.add(root);
        ArrayList<TreeNode> ans = new ArrayList<>();
        HashMap<TreeNode,TreeNode>parent = new HashMap<>();
        parent.put(root,null);
        while (!q.isEmpty()){
            Queue<TreeNode> q2 = new ArrayDeque<>();
            while (!q.isEmpty()){
                TreeNode tmp = q.poll();
                int d = mp.get(tmp);
                //删除
                boolean flag = false;
                if (set.contains(d)){
                    TreeNode f = parent.get(tmp);
                    if (f!=null){
                        f.left = null;
                        f.right = null;
                    }
                    flag = true;
                }else {
                    TreeNode f = parent.get(tmp);
                    if (f==null){
                        ans.add(tmp);
                    }
                }
                if (tmp.left!=null){
                    q2.add(tmp.left);
                    if (flag){
                        parent.put(tmp.left,null);
                    }else {
                        parent.put(tmp.left,tmp);
                    }
                }
                if (tmp.right!=null){
                    q2.add(tmp.right);
                    if (flag){
                        parent.put(tmp.right,null);
                    }else{
                        parent.put(tmp.right,tmp);
                    }
                }
            }
            q = q2;
        }
        return ans;
    }

    private void dfs(TreeNode root, int d) {
        if (root==null)return;
        mp.put(root,d);
        dfs(root.left,d+1);
        dfs(root.right,d+1);
    }
}
