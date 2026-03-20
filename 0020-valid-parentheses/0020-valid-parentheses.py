class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for i in s:
            if stack==[]:
                stack.append(i)
            elif i == '}':
                if stack and stack[-1]!='{':
                    return False
                stack.pop()
            elif i == ']':
                if stack and stack[-1]!='[':
                    return False
                stack.pop()
            elif i == ')':
                if stack and stack[-1]!='(':
                    return False
                stack.pop()
            else:
                stack.append(i)
        if not stack:
            return True
        return False

