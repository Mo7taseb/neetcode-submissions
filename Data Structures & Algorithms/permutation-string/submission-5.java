class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26];
        for(int i = 0; i< s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }
        int l = 0;
        int r = 0;
        while(r < s2.length()){
            while(arr[s2.charAt(r) - 'a'] == 0) {
                arr[s2.charAt(l) - 'a']++;
                l++;
                if(l > r) break;
            }
            arr[s2.charAt(r) - 'a']--;
            if(r - l + 1 == s1.length()) return true;
            r++;
        }
        return false;
    }
}
