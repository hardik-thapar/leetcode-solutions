class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int count=0;
        int n;
        for(int i=0;i<nums.size();i++){
            if(count==0) n = nums[i];
            if(nums[i]==n){
                count++;
            }
            else{
                count--;
            }
        }
        return n;
    }
};