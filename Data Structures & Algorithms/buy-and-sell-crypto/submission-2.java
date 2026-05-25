class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int l = 0;
        int r = 1;
        
        while (l < prices.length && r < prices.length) {
            if (prices[r] < prices[l]) {
                l = r;
                r++;
            }
            else {
                res = Math.max(res,(prices[r] - prices[l]));
                r++;
            }
        }
        
        return res;
    }
}
