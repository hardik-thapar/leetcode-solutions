class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String word = strs[i];
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            map.putIfAbsent(sorted,new ArrayList<>());
            map.get(sorted).add(word);

        }
        return new ArrayList<>(map.values());
    }
}