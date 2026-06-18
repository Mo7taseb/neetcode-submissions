class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = Math.min(nums[l], nums[r]);

        while (l <= r) {
            
            int mid = (l+r)/2;
            min = Math.min(min, nums[mid]);
            if(nums[mid] > nums[l]) {
                l = mid  + 1;
                if(l<nums.length)
                min = Math.min(min, nums[l]);
            }
            else {
                r = mid - 1;
                if(r>=0)
                min = Math.min(min, nums[r]);
            }
        }
        return min;
    }
}
