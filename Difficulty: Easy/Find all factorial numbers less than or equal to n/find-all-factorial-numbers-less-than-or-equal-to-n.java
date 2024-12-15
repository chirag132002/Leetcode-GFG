//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long N = sc.nextLong();

            Solution ob = new Solution();
            ArrayList<Long> ans = ob.factorialNumbers(N);
            for (long num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
     static long factorial(long i ){
        if(i==0) return 1;
        
        return i*factorial(i-1);
    }
    static ArrayList<Long> factorialNumbers(long n) {
        // code here
        long i=1;
        ArrayList<Long> list = new ArrayList<>();
        
        while (factorial(i)<=n){
             
            list.add(factorial(i));
            i++;
        }
        
        return list ;
        
    }
}