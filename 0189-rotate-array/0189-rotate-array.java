class Solution {
    // private int[] nums;

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
    reverse(nums, 0, n-k-1);
    reverse(nums, n-k, n-1);
    reverse(nums, 0, n-1);    
          
    }

static void reverse(int arr[], int start, int end){
    while(start<=end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}
}


    //     this.nums = nums;
    //     int n = nums.length;
    //     k %= n;
    //     reverse(0, n - 1);
    //     reverse(0, k - 1);
    //     reverse(k, n - 1);
    // ]

    // private void reverse(int i, int j) {
    //     for (; i < j; ++i, --j) {
    //         int t = nums[i];
    //         nums[i] = nums[j];
    //         nums[j] = t;
    //  }
            