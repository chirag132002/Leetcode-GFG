class Solution {
    public void moveZeroes(int[] a) {
         int n = a.length;
        int j = -1;

        // Find the first zero
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                j = i;
                break;
            }
        }

        // If no zeros are found, no need to proceed
        if (j == -1) return;

        // Move the pointers i and j and swap accordingly
        for (int i = j + 1; i < n; i++) {
            if (a[i] != 0) {
                // Swap a[i] and a[j]
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                j++;
            }
        }
    }
}