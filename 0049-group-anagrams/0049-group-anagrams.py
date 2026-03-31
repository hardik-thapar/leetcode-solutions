class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        freq={}
        res=[]
        for i, word in enumerate(strs):
            w="".join(sorted(word))
            if w not in freq:
                freq[w]=[]
            freq[w].append(word)
        for i,j in freq.items():
            res.append(j)
        return res

        