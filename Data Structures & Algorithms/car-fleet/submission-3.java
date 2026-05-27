class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[] arr = new int[target];
        int n = speed.length;
        int fleet = 1;
        for (int i = 0; i < n; i++) {
            arr[position[i]] = speed[i];
        }
        double steps = 0;
        double newSteps = 0;
        for (int i = target - 1; i >= 0; i--) {
            if (arr[i] != 0 && steps == 0) {
                steps = (double)(target - i) / (arr[i]);
                continue;
            }
            if (arr[i] != 0) {
                newSteps = (double)(target - i) / (arr[i]);
            }
            if(newSteps > steps) {
                fleet++;
                steps = newSteps;
            }
        }
        return fleet;
    }
}
