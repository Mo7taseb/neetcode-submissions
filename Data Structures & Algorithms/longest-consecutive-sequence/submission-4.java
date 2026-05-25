class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
           if (!set.contains(nums[i] - 1)) {
            int j = nums[i];
                while (set.contains(j + 1)) {
                    count++;
                    j++;
                }
            max = Math.max(max, count);
            count = 1;
           }
        }
        return max;
    }
}
