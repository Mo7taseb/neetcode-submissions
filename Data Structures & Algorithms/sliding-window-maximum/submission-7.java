class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int count = 0;
        int l = 0;
        Deque<Integer> q = new LinkedList<>();
        for(int r = 0; r < n; r++) {
            while(!q.isEmpty() && nums[r] > q.peekLast()) {
                q.removeLast();
            }
            q.offerLast(nums[r]);
            count++;
            if(count == k) {
                res[l] = q.peekFirst();
                if(nums[l] == res[l]) q.pollFirst();
                l++;
                count--;
            }
        }

        return res;
    }
}
