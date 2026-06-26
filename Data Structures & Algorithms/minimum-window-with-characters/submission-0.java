class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length())
        return "";
        int[] arr = new int[128];
        for(char c : t.toCharArray()){
            arr[c]++;
        }

        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;
        int count = t.length();
        for(int r = 0; r < s.length(); r++){
            char c1 = s.charAt(r);
            if(arr[c1]-- > 0) {
                count--;
            }
            while(count == 0) {
                if(r - l < minLen){
                    minLen = r - l + 1;
                    startIdx = l;
                }
                if(arr[s.charAt(l++)]++ == 0) {
                    count++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : new String(s.toCharArray(), startIdx, minLen);
    }
}
