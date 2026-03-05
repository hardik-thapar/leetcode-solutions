class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_map<int,int> freq;
        for(int i=0;i<nums.size();i++){
            
            freq[nums[i]]++;
            if(freq[nums[i]]>=2) return true;
        }
        // for(int x = 0; x<freq.size();x++){
        //     if(freq[x]>=2) return true;
        // }
        return false;
    }
};