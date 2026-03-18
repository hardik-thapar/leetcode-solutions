class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st = []
        for i in tokens:
            if i=='+':
                f=st.pop()
                s=st.pop()
                st.append(f+s)
            elif i=='-':
                f=st.pop()
                s=st.pop()
                st.append(s-f)
            elif i=='*':
                f=st.pop()
                s=st.pop()
                st.append(f*s)
            elif i=='/':
                f=st.pop()
                s=st.pop()
                st.append(round(int(s/f),1))
            else:
                st.append(int(i))
        return st[0]


        