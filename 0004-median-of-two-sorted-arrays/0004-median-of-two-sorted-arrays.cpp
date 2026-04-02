class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n1=nums1.size();
        int n2=nums2.size();
        vector<int> merged;
        for(int i=0;i<n1;i++){
            merged.push_back(nums1[i]);
        }
        for(int i=0;i<n2;i++){
            merged.push_back(nums2[i]);
        }
        sort(merged.begin(),merged.end());
        int n3=merged.size();
        if(n3%2==1){
            int a=n3/2;
            return static_cast<double>(merged[a]);
        }
        else{
            int a1=n3/2;
            int a2=n3/2 -1;
            return (static_cast<double>(merged[a1])+static_cast<double>(merged[a2]))/2.0;
        }
    }
};