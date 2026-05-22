class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer>[] arr = new ArrayList[nums.length + 1];
        int[] res = new int[k];

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (arr[entry.getValue()] == null) {
                arr[entry.getValue()] = new ArrayList<>();
                arr[entry.getValue()].add(entry.getKey());
            } else {
                arr[entry.getValue()].add(entry.getKey());
            }
        }
        

    
            for (int i = nums.length; i > 0; i--) {
                if (arr[i] != null) {
                for(int ele : arr[i]) {
                    if (k == 0) break;
                    res[k-1] = ele;
                    k--;
                } }
            }

        //  int index = 0;
        // for (int i = nums.length; i >= 0 && index < k; i--) {
        //     if (arr[i] != null) {
        //         for (int num : arr[i]) {
        //             res[index++] = num;
        //             if (index == k) {
        //                 break;
        //             }
        //         }
        //     }
        // }

        return res;
    }
}
