class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0) return null;
        StringBuilder res = new StringBuilder();
        for (int i =0 ; i < strs.size(); i++){
            if (strs.get(i).length() == 0) {
                res.append("-");
            }
            res.append(strs.get(i) + "#q");
        }
    return res.toString();
    }

    public List<String> decode(String str) {
        if (str == null) return new ArrayList<>();
        ArrayList<String> res = new ArrayList<>(Arrays.asList(str.split("#q")));
        for(int i = 0; i < res.size(); i++) {
            if (res.get(i).length() == 1 && res.get(i).charAt(0) == '-') {
                res.set(i, "");
            }
        }
        return res;

    }
}
