package leetcode_07;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author YuyaoHuang 20122659
 * @date 2022-06-24 14:53
 */
public class Bipartite {
   //uncolored node mark as 0
   static final int UNCOLORED = 0;
   //directly connected node in the graph,marked it as connected————1
   static final int CONNECTED = 1;
   //Not directly connected node in the graph,marked it as not_connected————2
   static final int NOT_CONNECTED = 2;
   int[] color;
   boolean res;

   public boolean isBipartite(int[][] graph) {
      int n = graph.length;
      res = true;
      color = new int[n];
      Arrays.fill(color, UNCOLORED);
      //start dfs
      for (int i = 0; i < n && res; ++i) {
         if (color[i] == UNCOLORED) {
            dfs(i, CONNECTED, graph);
         }
      }
      return res;
   }

   public void dfs(int node, int c, int[][] graph) {
      color[node] = c;
      int nextColor = 0;
      //paint the node————if they are neighbors marked as connected,else marked as not_connected
      if (c == CONNECTED) {
         nextColor = NOT_CONNECTED;
      } else {
         nextColor = CONNECTED;
      }
      //iterate with this node's neighbor
      for (int neighbor : graph[node]) {
         //Never visited
         if (color[neighbor] == UNCOLORED) {
            dfs(neighbor, nextColor, graph);
            if (!res) {
               return;
            }
            //visited and color!=nextColor,means it has already connected
         } else if (color[neighbor] != nextColor) {
            res = false;
            return;
         }
      }
   }
   //convert the graph from index-based to number-based
   public int[][] convert(int[][]G){
      int n = G.length;
      ArrayList<int[]> res = new ArrayList<>();
      for (int i = 0; i < n; i++) {
         ArrayList<Integer> list = new ArrayList<>();
         for (int j = 0; j < G[i].length; j++) {
            if (G[i][j]==1){
               list.add(j);
            }
         }
         res.add(list.stream().mapToInt(Integer::valueOf).toArray());
      }
      int[][] ans = new int[res.size()][];
      for (int i = 0; i < res.size(); i++) {
         ans[i]=res.get(i);
      }
      return ans;
   }
   public static void main(String[] args) {
      int G[][] = {{0, 1, 0, 1},
              {1, 0, 1, 0},
              {0, 1, 0, 1},
              {1, 0, 1, 0}
      };
      Bipartite b = new Bipartite();
      if (b.isBipartite(b.convert(G))) {
         System.out.println("Yes");
      } else {
         System.out.println("No");
      }
   }
}
