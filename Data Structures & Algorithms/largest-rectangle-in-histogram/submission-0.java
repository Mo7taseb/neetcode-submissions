class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i< n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int index = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = i - left - 1;
                res = Math.max(res, width * heights[index]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            int width = n - left - 1;
            res = Math.max(res, width*heights[index]);
        }

    return res;
    }
}