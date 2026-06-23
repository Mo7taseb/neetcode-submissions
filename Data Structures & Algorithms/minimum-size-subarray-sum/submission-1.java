class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int minSub = Integer.MAX_VALUE;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            r++;

            while (sum >= target) {
                minSub = Math.min(minSub, r - l );
                sum -= nums[l];
                l++;
            }
        }
        return minSub == Integer.MAX_VALUE ? 0 : minSub;
    }
}