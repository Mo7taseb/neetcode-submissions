class Solution {
    public int findDuplicate(int[] nums) {
        for(int num : nums) {
            int indx = Math.abs(num);
            if(nums[indx] < 0) {
                return indx;
            }
            else {
                nums[indx] *=-1;
            }
        }
        return -1;
    }
}
