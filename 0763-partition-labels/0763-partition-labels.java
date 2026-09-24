class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        char[] words = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            last[words[i]-'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while(i<words.length){
            int end = last[words[i]-'a'];
            int curr = i;
            while(i<=end){
                end = Math.max(end, last[words[i]-'a']);
                i++;
            }
            res.add(i-curr);
        }
        return res;
    }
}