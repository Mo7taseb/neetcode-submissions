class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = piles[0];
        if (h == n)
            return max;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, piles[i]);
        }

        int l = 1;
        int r = max;
        int k = 1;
        while (l <= r) {
            int total = 0;
            int mid = (l + r) / 2;
            for (int i = 0; i < n; i++) {
                total += Math.ceil((double) piles[i] / mid);
            }
            if (total <= h) {
                r = mid - 1;
                k = mid;
            } else {
                l = mid + 1;
            }
        }
        return k;
    }
}
