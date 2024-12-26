//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().quickSort(arr, 0, n - 1);
            printArray(arr);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high){
       if(low>=high){
           return;
       }
       int p=partition(arr,low,high);
       quickSort(arr,low,p-1);
       quickSort(arr,p+1,high);
    }
    static int partition(int arr[], int low, int high){
       int piv=arr[high];
       int i=low-1;
       for(int j=low;j<high;j++){
           if(arr[j]<piv){
               i++;
               int temp=arr[j];
               arr[j]=arr[i];
               arr[i]=temp;
           }
       }
       i++;
       int temp=piv;
       arr[high]=arr[i];
       arr[i]=temp;
       return i;
        }
        
    }
