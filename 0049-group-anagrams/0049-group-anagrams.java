class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String word: strs){
            char[] w = word.toCharArray();
            Arrays.sort(w);
            String sorted = new String(w);
            List<String> temp = map.getOrDefault(sorted,new ArrayList<>());
            temp.add(word);
            map.put(sorted, temp);
        }
        for(HashMap.Entry<String,List<String>> entry: map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}