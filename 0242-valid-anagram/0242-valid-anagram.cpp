class Solution {
public:
    bool isAnagram(string s, string t) {
    
    int n1 = s.length();
    int n2 = t.length();
    int n;
    if(n1!=n2) return false;
    n=n1;
    vector<int> freq1(26);
    vector<int> freq2(26);
    for(int i=0;i<n;i++){
        freq1[s[i]-'a']++;
        freq2[t[i]-'a']++;
    }
    for(int i=0;i<26;i++){
        if(freq1[i]!=freq2[i]) return false;
    }
    return true;
    }
};