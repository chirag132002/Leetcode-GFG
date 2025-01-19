//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    
    
    public boolean detect(int s, 
    ArrayList<ArrayList<Integer>> adj, 
    boolean[] vis,
    int[] parent){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(s, -1));
        vis[s] = true;
        while(!q.isEmpty()){
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();
            
            for(Integer it: adj.get(node)){
                if(vis[it] == false){
                    q.add(new Pair(it, node));
                    vis[it] = true;
                }
                else if(par != it) return true;
            }
   
        }
        return false;
         
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        boolean[] vis = new boolean[v];
        Arrays.fill(vis, false);
        int[] parent = new int[v];
        Arrays.fill(parent, -1);
        for(int i = 0; i< v; i++){
            if(vis[i] == false){
                if(detect(i, adj, vis, parent)){
                    return true;
                }
            }
        }
        return false;
        
    }
}