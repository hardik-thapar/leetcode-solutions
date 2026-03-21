class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st = []
        for i in tokens:
            if i == '+':
                x1 = st.pop()
                x2 = st.pop()
                st.append(x1+x2)
            elif i == '-':
                x1 = st.pop()
                x2 = st.pop()
                st.append(x2-x1)
            elif i == '*':
                x1 = st.pop()
                x2 = st.pop()
                st.append(x1*x2)
            elif i == '/':
                x1 = st.pop()
                x2 = st.pop()
                x3 = int(x2/x1)
                st.append(x3)
            else:
                st.append(int(i))
        return st[0]

        