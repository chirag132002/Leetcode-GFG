class Solution {
    public boolean checkValidString(String s) {
        int leftBalance = 0;
        int rightBalance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '*') {
                leftBalance++;
            } else {
                leftBalance--;
            }
            if (leftBalance < 0) return false;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')' || c == '*') {
                rightBalance++;
            } else {
                rightBalance--;
            }
            if (rightBalance < 0) return false;
        }
        return true;
    }
}