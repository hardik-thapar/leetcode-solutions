class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        count={}
        for i,word in enumerate(strs):
            key=''.join(sorted(word))
            if key not in count:
                count[key]=[]
            count[key].append(word)
        l=[]
        for i,j in count.items():
            l.append(j)
        return l
       
        