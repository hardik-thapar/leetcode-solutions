class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> s(nums.begin(),nums.end());
        int longest = 0;
        for(int x: s){
            if(s.find(x-1)==s.end()){
                int len = 1;
                int current = x;
                while(s.find(current+1)!=s.end()){
                    len++;
                    current = current+1;
                }
                longest = max(longest, len);
            }
        }
        return longest;
    }
};