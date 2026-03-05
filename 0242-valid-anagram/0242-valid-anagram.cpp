class Solution {
public:
    bool isAnagram(string s, string t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n1!=n2) return false;
        vector<int> freq(26);
        for(int i=0;i<n1;i++){
            freq[s[i]-'a']++;
            freq[t[i]-'a']--;
        }
        for(int x:freq){
            if(x!=0) return false;
        }
        return true;

    }
};