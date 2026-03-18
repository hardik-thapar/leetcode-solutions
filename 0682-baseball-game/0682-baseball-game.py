class Solution:
    def calPoints(self, operations: List[str]) -> int:
        res=[]
        for i in operations:
            if i =='+':
                res.append(res[-1]+res[-2])
            elif i=='C':
                if res:
                    res.pop()
            elif i=='D':
                res.append(2*res[-1])
            else:
                res.append(int(i))
        return sum(res)
    