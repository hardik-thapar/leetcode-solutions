class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string w = strs[0];
        string ans="";
        for(int i=0;i<w.length();i++){
            char c = w[i];
            for(int j =1; j<strs.size();j++){
                string q = strs[j];
                if(i>=q.length() || c!=q[i]){
                    return ans;
                }
            }
            ans+=c;
        }
        return ans;
    }
};