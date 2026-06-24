class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int l = 0;
        int count = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int r = 0; r < n; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            count++;
            while (count == k) {
                res[l] = map.lastKey();
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                if(map.get(nums[l])== 0) map.remove(nums[l]);
                l++;
                count--;
            }
        }

        return res;
    }
}
