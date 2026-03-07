class Solution {
public:
    void sortColors(vector<int>& nums) {
        int count[3]={0};
        for(int x:nums){
            if(x==0) count[0]++;
            else if(x==1) count[1]++;
            else count[2]++;
        }
//   for(int i:count){
//       cout<<i<<" ";
//   }
        int x=0;
        for(int i=0;i<nums.size();i++){
        
            while(count[x]==0) x++;
            nums[i]=x;
            count[x]--;
        
        }

    }
};