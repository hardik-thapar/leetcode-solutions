class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i=0; i<strs.length; i++){
            String word = strs[i];
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            // check the key exists or not
            if(!map.containsKey(sorted)){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sorted,list);
                }
            // if key exist 
            else{
                List<String> list = map.get(sorted);
                list.add(strs[i]);
                map.put(sorted,list);
            }
        }
        // List<List<String>> ans = map.values();
        return new ArrayList<>(map.values());
    }
}