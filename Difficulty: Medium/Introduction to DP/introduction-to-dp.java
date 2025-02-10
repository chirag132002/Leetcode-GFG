//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            long topDownans = obj.topDown(n);
            long bottomUpans = obj.bottomUp(n);
            if (topDownans != bottomUpans)
                System.out.println(-1);
            else
                System.out.println(topDownans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    private static final int MOD=1000000007;
    static long topDown(int n) {
        long[] dp=new long[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=-1;
        }
        return fibTopDown(n,dp);
    }
    private static long fibTopDown(int n,long[] dp){
        if(n==0) return 0;
        if(n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        dp[n]=(fibTopDown(n-1,dp)+fibTopDown(n-2,dp))%MOD;
        return dp[n];
    }

    static long bottomUp(int n) {
          if(n==0) return 0;
        if(n==1) return 1;
        long[] dp=new long[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%MOD;
        }
        return dp[n];
    }
}
