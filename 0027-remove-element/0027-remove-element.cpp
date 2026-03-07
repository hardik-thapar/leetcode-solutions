class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int k = count(nums.begin(),nums.end(), val);
        k=nums.size()-k;
        erase(nums, val);
        // for(int i=0;i<k;i++){
        //     nums.push_back(0);
        // }
        return k;
    }
};