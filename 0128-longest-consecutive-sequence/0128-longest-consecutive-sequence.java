class Solution {
    public int longestConsecutive(int[] a) {
        int n = a.length;
        if (n==0) return 0;
        
        int longest = 1;
        
        Set<Integer> set = new HashSet<>();
        for(int i: a){
            set.add(i);
        }
        
        for(int num: set){
            if(!set.contains(num -1)){
                int count = 1;
                int x = num;
                while(set.contains(x+1)){
                    x = x+ 1;
                    count+=1 ;
                }
                longest = Math.max(count, longest);
            }
        }
        return longest;
        
    }
        
    }