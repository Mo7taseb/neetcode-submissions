class TimeMap {
    HashMap<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            TreeMap<Integer, String> treeMap = map.get(key);
            Integer floorKey = treeMap.floorKey(timestamp);
            if (floorKey != null)
                return treeMap.get(floorKey);
        }
        return "";
    }
}
