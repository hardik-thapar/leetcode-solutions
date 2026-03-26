class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        st=max(weights)
        end=sum(weights)
        ans=[]
        while(st<=end):
            mid=(st+end)//2
            load=mid
            count=1
            t=0
            for i in weights:
            
                if t+i>load:
                    count+=1
                    t=i
                else:
                    t+=i
            if count<=days:
                ans.append(load)
                end=mid-1
            else:
                st=mid+1
        return min(ans)


        