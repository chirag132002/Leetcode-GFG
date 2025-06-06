//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        //count indegree
        int [] indegree =  new int[n];
        
        for(int i=0; i<V; i++){
            for(int v: adj.get(i))
                indegree[v]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<V; i++){
            //indegree==0 then add to q
            if(indegree[i]==0)
                q.offer(i);
        }
        
        int count=0;
        
        while(!q.isEmpty()){
            count++;
            int u = q.peek();
            q.poll();
            
            for(int v: adj.get(u)){
                indegree[v]--;
                
                if(indegree[v]==0){
                    q.offer(v);
                }
            }
        }
        
        if(count==V) return false;
        
        //cycle detected =>
        return true;
        
    }
}