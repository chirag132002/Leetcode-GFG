//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }

    Node(int d) {
        this.data = d;
        this.next = null;
    } // constructor to create a new node
}

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] numStrings = line.split(" ");
            int[] arr = new int[numStrings.length];
            for (int i = 0; i < numStrings.length; i++) {
                arr[i] = Integer.parseInt(numStrings[i]);
            }
            Solution ob = new Solution();
            Node ans = ob.constructLL(arr);
            while (ans != null) {
                System.out.print(ans.data + " ");
                ans = ans.next;
            }
            System.out.println();
        }
        scanner.close();
    }
}

//Back-end complete function Template for Java

// } Driver Code Ends


// User function Template for Java


/*class Node {
    int data;
    Node next;

    Node(int data, Node next){
    this.data = data;
    this.next = next;
     }
    
    Node(int data){
        this.data = data
    }
    
     
     //constructor to create a new node
}*/

class Solution {
    static Node constructLL(int arr[]) {
        

    int size=arr.length;
        Node head=null;
        Node tail=null;
        if(size==0) return null;


        for(int i=0;i<size;i++){
            Node node=new Node(arr[i]);
            if(head==null){
                head=node;
                tail=node;
            }
            else {
                tail.next=node;
                tail=node;
            }
        }


        return head;
    }
}
