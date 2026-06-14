class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        int i = 0;
        for(; i< nums.length; i++){
            res ^= nums[i] ^ i+1;
        }
        return res;
    }
}
