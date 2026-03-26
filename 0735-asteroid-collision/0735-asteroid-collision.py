class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        st=[]
        for i in range(len(asteroids)):
            x=asteroids[i]
            alive = True
            while st and st[-1]>0 and x<0:
                if abs(st[-1])<abs(x):
                    st.pop()
                    continue
                    
                elif abs(st[-1])==abs(x):
                    st.pop()
                    alive=False
                    break
                else:
                    alive = False
                    break
                    
            if alive: st.append(x)
                
            
        return st

                    
            
                

                
            
