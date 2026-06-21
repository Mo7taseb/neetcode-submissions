public class Pair{
    int timestamp;
    String value;
    Pair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}

class TimeMap {
    HashMap<String, List<Pair>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        String res = "";
        if(map.containsKey(key)) {
            List<Pair> list = map.get(key);
            int l = 0;
            int r = list.size() - 1;
            while(l <= r) {
                int mid = l + (r-l)/2;
                int time = list.get(mid).timestamp;
                if(time == timestamp) return list.get(mid).value;
                if(time <= timestamp) {
                    res = list.get(mid).value;
                    l = mid + 1;
                }
                else {
                    r = mid-1;
                }
            }
        }
            return res;
    }
}
