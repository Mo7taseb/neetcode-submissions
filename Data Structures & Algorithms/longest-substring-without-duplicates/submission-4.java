class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int i = 0;
        int j = 1;
        set.add(s.charAt(0));
        while (j < s.length()) {
            set.add(s.charAt(i));
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            } else {
                max = Math.max(max, set.size());
                i++;
                j = i + 1;
                set.clear();
            }
        }
        max = Math.max(max, set.size());
        return max;
    }
}
