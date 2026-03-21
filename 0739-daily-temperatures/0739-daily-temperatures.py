class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res=[0]*len(temperatures)
        stack=[] #2d list -> [temp][idx]
        for i,temp in enumerate(temperatures):
            while stack and temp>stack[-1][0]:
                st, sidx = stack.pop()
                res[sidx]=(i - sidx)
            stack.append([temp,i])
        return res
            
        